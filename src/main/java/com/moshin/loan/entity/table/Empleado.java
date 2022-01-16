package com.moshin.loan.entity.table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @Size(message = "El campo dni debe tener 8 dígitos", min = 8, max = 8)
    @NotNull(message = "El campo dni no debe ser nulo")
    @NotEmpty(message = "El campo dni no debe estar vacio")
    @Column(length = 8)
    private String cDNI;
    
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdUsu")
    @JsonManagedReference(value = "empleado-usuario")
    private Usuario usuario;
    
    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    @Column(length = 150, nullable = false)
    private String cNombre;

    @NotNull(message = "El campo apellidos no debe ser nulo")
    @NotEmpty(message = "El campo apellidos no debe estar vacio")
    @Column(length = 250, nullable = false)
    private String cApellidos;

    @ManyToOne( cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cRuc", nullable = false)
    private Empresa empresa;
    
    @NotNull(message = "El campo foto no debe ser nulo")
    @NotEmpty(message = "El campo foto no debe estar vacio")
    @Column(length = 150)
    private String cFoto;

    @NotNull(message = "El campo telefono no debe ser nulo")
    @NotEmpty(message = "El campo telefono no debe estar vacio")
    @Size(message = "El campo telefono debe tener 9 dígitos", min = 9, max = 9)
    @Column(length = 9, nullable = false)
    private String cTelefono;
    
    @Column(nullable = false)
    private boolean bActivo;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtFechaReg;
}
