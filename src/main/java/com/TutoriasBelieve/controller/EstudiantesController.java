/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve.controller;

/**
 *
 * @author fabia
 */

import com.TutoriasBelieve.entity.Estudiante;
import com.TutoriasBelieve.service.IEstudianteService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class EstudiantesController {
    
    
    @Autowired
    private IEstudianteService estudianteService;
    
    @GetMapping("/estudiantes")
    public String index(Model model){
    
        List<Estudiante> listaEstudiantes=estudianteService.getAllStudent();
        model.addAttribute("titulo","Estudiantes");
        model.addAttribute("estudiante", listaEstudiantes);
        return "estudiantes";
    
    }
    
    @GetMapping("/estudiantesN")
    public String crearEstudiante(Model model){
    
        model.addAttribute("estudiante", new Estudiante());
        
        return "crear";
    
    }
    
    @PostMapping("/save")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante){
    
        estudianteService.saveStudent(estudiante);
        return "redirect:/estudiante";
        
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarEstudiante(@PathVariable("id") Long id){
    
        estudianteService.delete(id);
        return "redirect:/estudiante";
    
    }
    
    
}
