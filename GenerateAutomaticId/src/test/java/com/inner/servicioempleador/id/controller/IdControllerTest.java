package com.inner.servicioempleador.id.controller;

import com.inner.servicioempleador.id.models.ApiResponse;
import com.inner.servicioempleador.id.service.IdGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IdControllerTest {

    @Test
    public void testGenerateId_Success() {

        IdGenerator idGeneratorMock = Mockito.mock(IdGenerator.class);
        Mockito.when(idGeneratorMock.generateId()).thenReturn("testId");

        IdController idController = new IdController(idGeneratorMock);
        ResponseEntity<ApiResponse> responseEntity = idController.generateId();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("testId", responseEntity.getBody().getId());

    }
}
