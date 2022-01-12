package com.moshin.loan.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(length = 8)
    private String cDNI;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdUsu", referencedColumnName = "nId")
    @JsonManagedReference(value = "cliente-usuario")
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
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date dtFechaReg;
}
