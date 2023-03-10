/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.security;

import com.pe.sh.Veterinaria.model.Roles;
import com.pe.sh.Veterinaria.model.Usuarios;
import com.pe.sh.Veterinaria.repository.UsuariosRepository;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
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
 * @author shmen
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Override
    public UserDetails loadUserByUsername(String nombreus) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByNombreus(nombreus)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con ese username: " + nombreus));
        return new User(usuario.getNombreus(), usuario.getContraus(), mapearRoles(usuario.getRoles()));
    }
    
    private Collection<? extends GrantedAuthority> mapearRoles(Set<Roles> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).collect(Collectors.toList());
    }
    
}
