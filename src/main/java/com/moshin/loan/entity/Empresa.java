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
@Table(name = "empresa")
@Data
public class Empresa {
    @Id
    private String cRUC;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nIdUsu")
    private Usuario usuario;

    @Column(length = 150)
    private String cNombre;
    @Column(length = 150)
    private String cRazonSocial;
    @Column(length = 9)
    private String cTelefono;
    @Column(length = 150)
    private String cFoto;
    @Column
    private Date dtFechaReg;

    @OneToOne(mappedBy = "empresa")
    Empleado empleado;
}
