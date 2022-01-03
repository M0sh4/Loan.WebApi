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
@Table(name = "cliente")
@Data
public class Cliente {
    @Id
    private String cDNI;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nIdUsu")
    private Usuario usuario;

    @Column(length = 50)
    private String cNombres;
    @Column(length = 100)
    private String cApellidos;
    @Column(length = 9)
    private String cTelefono;
    @Column(length = 250)
    private String cDireccion;
    @Column(length = 250)
    private String cCorreo;
    @Column(length = 250)
    private String cFoto;
    @Column
    private Date dtFechaReg;
}
