/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pe.sh.Veterinaria.repository;

import com.pe.sh.Veterinaria.model.Mascotas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author shmen
 */
public interface MascotasRepository extends JpaRepository<Mascotas, String>{
    
    List<Mascotas> findByClientesId(String codigocl);
    
}
