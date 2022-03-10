/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve.service;

import com.TutoriasBelieve.entity.Estudiante;
import com.TutoriasBelieve.repository.EstudianteRepository;
import java.util.List;
import java.util.Optional;
import com.TutoriasBelieve.service.IEstudianteService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author fabia
 */

@Service
public class EstudianteService implements IEstudianteService{
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Override
    public List<Estudiante> getAllStudent(){
    
        return (List<Estudiante>)estudianteRepository.findAll();
    
    }

    @Override
    public void saveStudent(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante getStudentById(long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        estudianteRepository.deleteById(id);
    }
    
    
    public void find(long id) {
        estudianteRepository.findById(id);
    }
    
}
