package com.example.demo.service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> getEmpleadoById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado saveOrUpdateEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }

    public String sendMessage(String message) {
        return restTemplate.postForObject("http://localhost:8085/receive", message, String.class);
    }

   /* public Object sendMessageJson(Object jsonMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> requestEntity = new HttpEntity<>(jsonMessage, headers);

        return restTemplate.postForObject("http://localhost:8085/receive-json", requestEntity, Object.class);
    }*/

    public String sendMessageJson(Empleado empleado) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Empleado> requestEntity = new HttpEntity<>(empleado, headers);

        return restTemplate.postForObject("http://localhost:8085/receive-json", requestEntity, String.class);
    }

}

