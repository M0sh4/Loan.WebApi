package com.moshin.loan.entity.table;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @NotNull(message = "El campo usuario no debe ser null")
    @NotEmpty(message = "El campo usuario no debe estar vacio")
    @Column(length = 40, nullable = false, unique = true)
    private String cUsuario;

    @NotNull(message = "El campo contraseña no debe ser null")
    @NotEmpty(message = "El campo contraseña no debe estar vacio")
    @Column(length = 60, nullable = false)
    private String cContrasena;

    @NotNull(message = "El campo tipo de usuario no debe ser null")
    @NotEmpty(message = "El campo tipo de usuario no debe estar vacio")
    @Column(length = 1, nullable = false)
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
