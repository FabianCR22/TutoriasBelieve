/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve.controller;

/**
 *
 * @author fabia
 */

import com.TutoriasBelieve.entity.Pais;
import com.TutoriasBelieve.entity.Persona;
import com.TutoriasBelieve.service.IPaisService;
import com.TutoriasBelieve.service.IPersonaService;
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
public class PersonasController {
    
    
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    @GetMapping("/personas")
    public String index(Model model){
    
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";
    
    }
    
    @GetMapping("/personasN")
    public String crearPersona(Model model){
    
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona", new Persona());
        model.addAttribute("paises", listaPais);
        
        return "crear";
    
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
    
        personaService.savePerson(persona);
        return "redirect:/personas";
        
    }
    
    @GetMapping("/editPersona/{id}")
    public String editarPersona(@PathVariable("id") Long idPersona, Model model){
    
        Persona persona = personaService.getPersonById(idPersona);
        List<Pais> listaPais = paisService.listCountry();
        model.addAttribute("persona", persona);
        model.addAttribute("paises", listaPais);
        
        return "crear";
    
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long id){
    
        personaService.delete(id);
        return "redirect:/personas";
    
    }
    
    
    
}
