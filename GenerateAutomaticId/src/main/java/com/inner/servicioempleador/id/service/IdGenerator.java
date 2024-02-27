package com.inner.servicioempleador.id.service;

import com.inner.servicioempleador.id.models.GenerateIdModel;
import com.inner.servicioempleador.id.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

/*
* Service File, id generator through timestamp and RandomAlphanumeric method.
*/

@Service
public class IdGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdGenerator.class);

    private final CassandraTemplate cassandraTemplate;

    @Autowired
    public IdGenerator(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    /*
     * This method generate id, and concatenates timestamp and randomAlphanumeric methods.
     * */
    public String generateId() {
        String alphanumericId;
        do {
            alphanumericId = generateTimestamp() + generateRandomAlphanumeric();
        } while (checkIdExists(alphanumericId));
        saveGeneratedId(alphanumericId);
        return alphanumericId;
    }

    /*
     * This method generate id through timestamp in milliseconds.
     * */
    private Long generateTimestamp() {
        return Instant.now().toEpochMilli();
    }

    /*
     * This method generate id through random alphanumeric script using uppercase, lowercase and numbers.
     * */
    private String generateRandomAlphanumeric() {
        String alphanumericCharacters = Constants.ALPHANUMERIC_CHARACTERS;
        int length = 10;

        Random random = new Random();
        return random.ints(length, 0, alphanumericCharacters.length())
                .mapToObj(alphanumericCharacters::charAt)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

    /*
    * This method check id exist in DB cassandra, if return false, continue with id generator
    * */
    private boolean checkIdExists(String alphanumericId) {
        return cassandraTemplate.exists(alphanumericId, GenerateIdModel.class);
    }

    /*
     * This method insert data in DB cassandra.
     * */
    private void saveGeneratedId(String alphanumericId) {
        GenerateIdModel generatedId = new GenerateIdModel();
        generatedId.setId(alphanumericId);
        generatedId.setCreatedDate(new Date());
        cassandraTemplate.insert(generatedId);
    }
}
