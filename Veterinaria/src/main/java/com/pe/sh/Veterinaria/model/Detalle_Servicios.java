/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pe.sh.Veterinaria.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author shmen
 */
@Entity
@Table(name = "DETALLE_SERVICIOS")
public class Detalle_Servicios implements Serializable{
    
    @Id
    @Column(name = "codigodet_ser")
    @GeneratedValue(generator = "inc_seqDsv")
    @GenericGenerator(name = "inc_seqDsv", strategy = "com.pe.sh.Veterinaria.configuration.StringKeyGenerator",
            parameters = {@Parameter(name = "sqcName", value = "DETALLE_SERVICIOS_INC"),
                          @Parameter(name = "identificator_id", value = "DS")})
    @SequenceGenerator(name = "inc_seqDsv", sequenceName = "DETALLE_SERVICIOS_INC", initialValue = 1, allocationSize = 1)
    private String codigodet_ser;
    
    @Column(name = "descrip")
    private String descrip;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoser", nullable = false)
    private Servicios codigoserfk;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigocit", nullable = false)
    private Citas codigocitfk;

    public Detalle_Servicios() {
    }

    public Detalle_Servicios(String codigodet_ser, String descrip, Servicios codigoserfk, Citas codigocitfk) {
        this.codigodet_ser = codigodet_ser;
        this.descrip = descrip;
        this.codigoserfk = codigoserfk;
        this.codigocitfk = codigocitfk;
    }

    public String getCodigodet_ser() {
        return codigodet_ser;
    }

    public void setCodigodet_ser(String codigodet_ser) {
        this.codigodet_ser = codigodet_ser;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Servicios getCodigoser() {
        return codigoserfk;
    }

    public void setCodigoser(Servicios codigoserfk) {
        this.codigoserfk = codigoserfk;
    }

    public Citas getCodigocit() {
        return codigocitfk;
    }

    public void setCodigocit(Citas codigocitfk) {
        this.codigocitfk = codigocitfk;
    }
    
    
    
}
