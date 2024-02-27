package com.inner.servicioempleador.id.service;

import com.inner.servicioempleador.id.models.GenerateIdModel;
import org.junit.jupiter.api.Test;
import org.springframework.data.cassandra.core.CassandraTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IdGeneratorTest {

    @Test
    public void testGenerateId() {

        CassandraTemplate cassandraTemplateMock = mock(CassandraTemplate.class);
        when(cassandraTemplateMock.exists("testId", GenerateIdModel.class)).thenReturn(false);

        IdGenerator idGenerator = new IdGenerator(cassandraTemplateMock);

        String generatedId = idGenerator.generateId();

        assertEquals(23, generatedId.length());
    }
}
