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
@Table(name = "lista_negra")
@Data
public class ListaNegra {
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
    private String cRazon;
    @Column
    private Date dtFechaReg;
}
