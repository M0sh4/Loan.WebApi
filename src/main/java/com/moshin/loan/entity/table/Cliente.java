package com.moshin.loan.entity.table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @Size(message = "El campo dni debe tener 8 dígitos", min = 8, max = 8)
    @NotNull(message = "El campo dni no puede ser nulo")
    @NotEmpty(message = "El campo dni no puede estar vacio")
    private String cDNI;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdUsu", referencedColumnName = "nId")
    @JsonManagedReference(value = "cliente-usuario")
    private Usuario usuario;

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Column(length = 50, nullable = false)
    private String cNombres;

    @NotNull(message = "El campo apellidos no puede ser nulo")
    @NotEmpty(message = "El campo apellidos no puede estar vacio")
    @Column(length = 100, nullable = false)
    private String cApellidos;

    @NotNull(message = "El campo telefono no puede ser nulo")
    @NotEmpty(message = "El campo telefono no puede estar vacio")
    @Size(message = "El campo telefono debe tener 9 dígitos", min = 9, max = 9)
    @Column(length = 9, nullable = false)
    private String cTelefono;

    @NotNull(message = "El campo dirección no puede ser nulo")
    @NotEmpty(message = "El campo dirección no puede estar vacio")
    @Column(length = 250)
    private String cDireccion;

    @NotNull(message = "El campo correo no puede ser nulo")
    @NotEmpty(message = "El campo correo no puede estar vacio")
    @Email(message = "El campo correo debe ser un dirección de correo eletrónico con formato correcto")
    @Column(length = 250, nullable = false, unique = true)
    private String cCorreo;

    @NotNull(message = "El campo foto no puede ser nulo")
    @NotEmpty(message = "El campo foto no puede estar vacio")
    @Column(length = 250, nullable = false)
    private String cFoto;

    @Column(nullable = false)
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date dtFechaReg;
}
