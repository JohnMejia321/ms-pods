package com.inner.servicioempleador.id.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiResponseTest {

    @Test
    public void testApiResponse() {

        String id = "123456";
        ApiResponse response = new ApiResponse(id);

        assertEquals(id, response.getId());
    }
}
