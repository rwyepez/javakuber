package com.example.personas.service;

import com.example.personas.entity.Persona;

import java.util.List;

public interface PersonaService {

    List<Persona> listPersonas();

    Persona guardarPersona(Persona persona);

    Persona actualizarPersona(Persona persona);

    void eliminarPersona(int id);
}
