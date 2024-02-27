package com.inner.servicioempleador.id.config;

import org.junit.jupiter.api.Test;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CassandraConfigTest {

    @Test
    public void testGetKeyspaceName() {
        CassandraConfig config = new CassandraConfig();
        assertEquals("cristian", config.getKeyspaceName());
    }

    @Test
    public void testGetKeyspaceCreations() {
        CassandraConfig config = new CassandraConfig();
        List<CreateKeyspaceSpecification> creations = config.getKeyspaceCreations();
        assertEquals(1, creations.size());
        CreateKeyspaceSpecification specification = creations.get(0);
        assertEquals("cristian", specification.getName().asCql(true));
        assertEquals(false, specification.getOptions().containsKey(KeyspaceOption.DURABLE_WRITES));
    }

    @Test
    public void testGetSchemaAction() {
        CassandraConfig config = new CassandraConfig();
        assertEquals(SchemaAction.CREATE_IF_NOT_EXISTS, config.getSchemaAction());
    }

    @Test
    public void testGetEntityBasePackages() {
        CassandraConfig config = new CassandraConfig();
        assertEquals("com.inner.consulting.id.models", config.getEntityBasePackages()[0]);
    }
}
