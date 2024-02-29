package com.inner.consulting;

import com.hazelcast.collection.IList;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.jet.JetInstance;
import com.inner.consulting.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class AppTest {

    @Mock
    private HazelcastInstance hz;

    @Mock
    private JetInstance jet;

    @Mock
    private IList<Object> sourceList;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEjecutarPipeline() {
        // Preparar los datos de prueba
        String ocrResult = "ocrResult";
        String empleadorId = "empleadorId";

        // Simular los métodos estáticos
        try (MockedStatic<Hazelcast> hazelcastMock = Mockito.mockStatic(Hazelcast.class)) {
            hazelcastMock.when(Hazelcast::bootstrappedInstance).thenReturn(hz);
            when(hz.getJet()).thenReturn(jet);

            // Aquí simulamos el método getList para devolver sourceList en lugar de null
            when(hz.getList("sourceList")).thenReturn(sourceList);

            // Llamar al método que se está probando
            App.ejecutarPipeline(ocrResult, empleadorId);

            // Verificar que los métodos del mock fueron llamados correctamente
            verify(sourceList, times(1)).clear(); // Verifica que el método clear() fue llamado en sourceList
        }
    }
}
