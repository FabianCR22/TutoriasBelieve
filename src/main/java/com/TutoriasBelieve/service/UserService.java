/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.TutoriasBelieve.service;

import com.TutoriasBelieve.entity.Persona;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author fabia
 */


@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    public IPersonaService personaService;
    
    @Override
    public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException{
    
        Persona persona = this.personaService.findByNombre (username);
        Userprincipal userPrincipal = new Userprincipal(persona);
        return userPrincipal;
    
    }
    
    
}
