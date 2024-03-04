package com.example.demo.controller;


import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<Empleado> getAllEmpleados() {
        return empleadoService.getAllEmpleados();
    }

    @GetMapping("/{id}")
    public Optional<Empleado> getEmpleadoById(@PathVariable Long id) {
        return empleadoService.getEmpleadoById(id);
    }

    @PostMapping
    public Empleado saveEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.saveOrUpdateEmpleado(empleado);
    }

    @PostMapping("/send/{message}")
    public String sendMessage(@PathVariable String message) {
        empleadoService.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/test")
    public String test() {
        logger.info("endpoint de prueba");
        return "endpoint de prueba";
    }

    @PostMapping("/send-json")
    public String sendMessage(@RequestBody Empleado jsonMessage) {
        empleadoService.sendMessageJson(jsonMessage);
        return "Message sent successfully";
    }

}

