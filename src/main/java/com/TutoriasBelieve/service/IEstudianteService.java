/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TutoriasBelieve.service;

/**
 *
 * @author fabia
 */

import com.TutoriasBelieve.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface IEstudianteService {
    
    public List<Estudiante> getAllStudent();
    public void saveStudent(Estudiante estudiante);
    public Estudiante getStudentById(long id);
    public void delete(long id);
    
}
