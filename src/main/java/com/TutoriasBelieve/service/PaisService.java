/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve.service;

/**
 *
 * @author fabia
 */

import com.TutoriasBelieve.entity.Pais;
import com.TutoriasBelieve.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.TutoriasBelieve.service.IPaisService;


@Service
public class PaisService implements IPaisService{ 
    
    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> listCountry(){

        return (List<Pais>) paisRepository.findAll();
    
    }
    
    
}
