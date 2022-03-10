/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.TutoriasBelieve.repository;

import com.TutoriasBelieve.entity.Estudiante;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fabia
 */

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante,Long>{
    
}
