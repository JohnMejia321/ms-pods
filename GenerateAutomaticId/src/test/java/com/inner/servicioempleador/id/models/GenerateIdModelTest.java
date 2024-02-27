package com.inner.servicioempleador.id.models;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenerateIdModelTest {
    @Test
    public void testGenerateIdModel() {

        String id = "123456";
        String idGenerate = "789012";
        Date createdDate = new Date();
        GenerateIdModel model = new GenerateIdModel(id, createdDate);

        assertEquals(id, model.getId());
        assertEquals(createdDate, model.getCreatedDate());
    }
}
