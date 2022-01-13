package com.moshin.loan.entity.table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "cliente-usuario")
    Cliente cliente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "empleado-usuario")
    Empleado empleado;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.REFRESH)
    @JsonBackReference(value = "empresa-usuario")
    Empresa empresa;
}
