/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve.service;


import com.TutoriasBelieve.entity.Persona;
import com.TutoriasBelieve.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import com.TutoriasBelieve.service.IPersonaService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fabia
 */

@Service
public class PersonaService implements IPersonaService{
    
    //Inyeccion de dependencias
    @Autowired
    private PersonaRepository personaRepository;
    
    @Override
    public List<Persona> getAllPerson(){
    
        return (List<Persona>)personaRepository.findAll();
    
    }

    @Override
    public void savePerson(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public Persona getPersonById(long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id);
    }
    
    
    public void find(long id) {
        personaRepository.findById(id);
    }
    
    @Override
    public Persona findByNombre (String nombre){
    
        return personaRepository.findByNombre(nombre);
    
    }
    
    
}
