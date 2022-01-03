package com.moshin.loan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "documento")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cDni")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cRuc")
    private Empresa empresa;
    
    @Column(length = 150)
    private String cNombre;
    @Column
    private Date dtFechaReg;
    @Column(length = 1)
    private String cEstado;
}
