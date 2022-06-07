package com.example.personas.controller;

import com.example.personas.entity.Persona;
import com.example.personas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    @RequestMapping(value = "obtain", method = RequestMethod.GET)
    public ResponseEntity<?> getPersonas(){
        List<Persona> personaList = this.personaService.listPersonas();
        return ResponseEntity.ok(personaList);
    }

    @PostMapping
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> savePersona(@RequestBody Persona persona){
        Persona p = this.personaService.guardarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @PutMapping
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePersona(@RequestBody Persona persona){
        Persona p = this.personaService.actualizarPersona(persona);
        return ResponseEntity.status(HttpStatus.CREATED).body(p);
    }

    @DeleteMapping
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePersona(@PathVariable int id){
        this.personaService.eliminarPersona(id);
        return ResponseEntity.ok().build();
    }
}
