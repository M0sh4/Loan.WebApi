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
@Table(name = "pago")
@Data
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nIdPrestamo")
    private Prestamo prestamo;
    
    @Column
    private double nMonto;
    @Column
    private Date dtFecha;
    @Column(length = 1)
    private String cEstado;
}
