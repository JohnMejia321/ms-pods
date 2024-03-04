package com.inner.consulting.service;

import com.inner.consulting.controller.MessagesController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Service
public class MessagesServices  {

    private static final Logger logger = LoggerFactory.getLogger(MessagesServices.class);

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    @Autowired
    private  ConsumerFactory<String, String> consumerFactory;


    public Map<String, Object> receiveMessageJson(Map<String, Object> jsonMessage) {
        kafkaTemplate.send("topic-job",jsonMessage.toString());
        return jsonMessage;
    }



    @KafkaListener(topics = "topic-pipeline", groupId = "my_group_id")
    public void listenKakfa(String message) {
        logger.info(message);
        String url = "http://localhost:9090/api/v1/test";
        ResponseEntity<String> response = restTemplate.getForEntity(url,  String.class);
        logger.info(response.getBody());
    }



}
