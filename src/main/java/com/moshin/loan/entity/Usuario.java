package com.moshin.loan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;
    @Column(length = 40)
    private String cUsuario;
    @Column(length = 60)
    private String cContrasena;
    @Column(length = 1)
    private String cTipoUsuario;

    @OneToOne(mappedBy = "usuario")
    Cliente cliente;

    @OneToOne(mappedBy = "usuario")
    Empleado empleado;

    @OneToOne(mappedBy = "usuario")
    Empresa empresa;
}
