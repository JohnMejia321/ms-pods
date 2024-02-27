package com.inner.consulting;

import com.hazelcast.collection.IList;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.jet.JetInstance;
import com.hazelcast.jet.Job;
import com.hazelcast.jet.pipeline.Pipeline;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testEjecutarPipeline() {
        // Crear un mock de HazelcastInstance
        HazelcastInstance hzMock = mock(HazelcastInstance.class);

        // Crear un mock de JetInstance
        JetInstance jetMock = mock(JetInstance.class);

        // Crear un mock de Job
        Job jobMock = mock(Job.class);

        // Crear un mock de IList
        //IList listMock = mock(IList.class);
       //IList<String> listMock = mock(IList.class);


        // Cuando se llame al método getJet de hzMock, retornar jetMock
        when(hzMock.getJet()).thenReturn(jetMock);

        // Cuando se llame al método getList de hzMock, retornar listMock
        //when(hzMock.getList("sourceList")).thenReturn(listMock);

        // Cuando se llame al método newJob de jetMock, retornar jobMock
        when(jetMock.newJob(any(Pipeline.class))).thenReturn(jobMock);

        // Llamar al método que quieres probar
      //  App.ejecutarPipeline("ocrResult", "empleadorId");

        // Verificar que se llamó al método newJob con el pipeline correcto
        verify(jetMock).newJob(any(Pipeline.class));

        // Verificar que se llamó al método add de listMock con el ocrResult correcto
      //  verify(listMock).add("ocrResult");
    }


}
