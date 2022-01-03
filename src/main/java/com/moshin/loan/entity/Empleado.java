package com.moshin.loan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "empleado")
@Data
public class Empleado {
    @Id
    private String cDNI;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nIdUsu")
    private Usuario usuario;

    @Column(length = 150)
    private String cNombre;
    @Column(length = 250)
    private String cApellidos;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "cRuc")
    private Empresa empresa;
    
    @Column(length = 150)
    private String cFoto;
    @Column(length = 9)
    private String cTelefono;
    @Column(length = 1)
    private String cEstado;
    @Column
    private Date dtFechaReg;
}
