package com.example.personas.service.impl;

import com.example.personas.entity.Persona;
import com.example.personas.repository.PersonaRepository;
import com.example.personas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> listPersonas() {
        List<Persona> personas = StreamSupport.stream(this.personaRepository.findAll().spliterator(), false).collect(Collectors.toList());

        return personas;
    }

    @Override
    public Persona guardarPersona(Persona persona) {

        return this.personaRepository.save(persona);
    }

    @Override
    public Persona actualizarPersona(Persona persona) {
        return this.personaRepository.save(persona);
    }

    @Override
    public void eliminarPersona(int id) {
        this.personaRepository.deleteById(id);
    }
}
