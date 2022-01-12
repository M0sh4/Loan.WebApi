package com.moshin.loan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @Column(length = 11)
    private String cRUC;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdUsu")
    @JsonManagedReference(value = "empresa-usuario")
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
}
