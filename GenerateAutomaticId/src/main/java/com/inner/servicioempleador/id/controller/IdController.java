package com.inner.servicioempleador.id.controller;

import com.inner.servicioempleador.id.models.ApiResponse;
import com.inner.servicioempleador.id.service.IdGenerator;
import com.inner.servicioempleador.id.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
*   Controller file and expose Api Rest through endpoint.
*/

@RestController
public class IdController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IdController.class);

    private final IdGenerator idGenerator;

    @Autowired
    public IdController(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    @GetMapping("/generatedId")
    public ResponseEntity<ApiResponse> generateId() {
        try {
            String message = String.valueOf(idGenerator.generateId());
            ApiResponse response = new ApiResponse(message);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error(Constants.ERROR_RESPONSE);
        }
        return null;
    }
}
