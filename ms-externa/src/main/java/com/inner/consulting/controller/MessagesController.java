package com.inner.consulting.controller;


import com.inner.consulting.service.MessagesServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class MessagesController {

    private static final Logger logger = LoggerFactory.getLogger(MessagesController.class);


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    
    @Autowired
    private MessagesServices messagesServices;


    @PostMapping("/receive-json")
    public Map<String, Object> receiveMessage(@RequestBody Map<String, Object> jsonMessage) {
        logger.info(jsonMessage.toString());
        return messagesServices.receiveMessageJson(jsonMessage);
    }


}
