/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "USUARIOS")
public class Usuarios implements Serializable{
    
    @Id
    @Column(name = "codigous")
    @GeneratedValue(generator = "inc_seqUsu")
    @GenericGenerator(name = "inc_seqUsu", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "USUARIOS_INC"),
                          @Parameter(name = "identificator_id", value = "US")})
    @SequenceGenerator(name = "inc_seqUsu", sequenceName = "USUARIOS_INC", initialValue = 1, allocationSize = 1)
    private String id;
    
    @Column(name = "nombreus")
    private String nombreus;
    
    @Column(name = "contraus")
    private String contraus;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "codigove")
    private Veterinarios veterinario;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "USUARIOS_ROLES", joinColumns = @JoinColumn(name = "codigous", referencedColumnName = "codigous")
            , inverseJoinColumns = @JoinColumn(name = "codigorol", referencedColumnName = "codigorol"))
    private Set<Roles> roles = new HashSet<>();
    
    public Usuarios() {
    }

    public Usuarios(String id, String nombreus, String contraus, Veterinarios veterinario) {
        this.id = id;
        this.nombreus = nombreus;
        this.contraus = contraus;
        this.veterinario = veterinario;
    }

    public String getCodigous() {
        return id;
    }

    public void setCodigous(String id) {
        this.id = id;
    }

    public String getNombreus() {
        return nombreus;
    }

    public void setNombreus(String nombreus) {
        this.nombreus = nombreus;
    }

    public String getContraus() {
        return contraus;
    }

    public void setContraus(String contraus) {
        this.contraus = contraus;
    }

    public Veterinarios getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinarios veterinario) {
        this.veterinario = veterinario;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
    
    
    
}
