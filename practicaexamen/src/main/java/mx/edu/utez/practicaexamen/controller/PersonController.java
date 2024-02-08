package mx.edu.utez.practicaexamen.controller;

import jakarta.validation.Valid;
import mx.edu.utez.practicaexamen.config.ApiResponse;
import mx.edu.utez.practicaexamen.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")

public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

}
