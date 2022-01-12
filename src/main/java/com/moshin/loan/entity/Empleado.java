package com.moshin.loan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @Column(length = 8)
    private String cDNI;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdUsu")
    @JsonManagedReference(value = "empleado-usuario")
    private Usuario usuario;

    @Column(length = 150)
    private String cNombre;
    @Column(length = 250)
    private String cApellidos;

    @ManyToOne( cascade = CascadeType.REFRESH)
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
