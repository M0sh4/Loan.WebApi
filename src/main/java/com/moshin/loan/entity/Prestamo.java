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
@Table(name = "prestamo")
@Data
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cDni")
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cRuc")
    private Empresa empresa;

    @Column
    private String nMonto;
    @Column
    private Date dtFechaIni;
    @Column
    private Date dtFechaFin;
    @Column(length = 1)
    private String cEstado;
 
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nIdTipoPrestamo")
    private TipoPrestamo tipoPrestamo;
}
