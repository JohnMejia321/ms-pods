package com.inner.servicioempleador.id.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConstantsTest {

    @Test
    void testAlphanumericCharacters() {
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789", Constants.ALPHANUMERIC_CHARACTERS);
    }

    @Test
    void testKeyspaceName() {
        assertEquals("cristian", Constants.KEYSPACE_NAME);
    }

    @Test
    void testEntityBasePackage() {
        assertEquals("com.inner.servicioempleador.id.models", Constants.ENTITY_BASE_PACKAGE);
    }

    @Test
    void testErrorResponse() {
        assertEquals("An unexpected error occurred Generating ID", Constants.ERROR_RESPONSE);
    }
}
