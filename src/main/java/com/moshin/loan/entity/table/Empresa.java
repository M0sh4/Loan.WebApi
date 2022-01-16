package com.moshin.loan.entity.table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "empresa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
    @Id
    @Size(message = "El campo ruc debe tener 11 dígitos", min = 11, max = 11)
    @NotNull(message = "El campo ruc no debe ser nulo")
    @NotEmpty(message = "El campo ruc no debe estar vacio")
    @Column(length = 11)
    private String cRUC;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdUsu")
    @JsonManagedReference(value = "empresa-usuario")
    private Usuario usuario;

    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    @Column(length = 150, nullable = false)
    private String cNombre;
    
    @NotNull(message = "El campo razón social no debe ser nulo")
    @NotEmpty(message = "El campo razón social no debe estar vacio")
    @Column(length = 150, nullable = false)
    private String cRazonSocial;
    
    @NotNull(message = "El campo telefono no debe ser nulo")
    @NotEmpty(message = "El campo telefono no debe estar vacio")
    @Size(message = "El campo telefono debe tener 9 dígitos", min = 9, max = 9)
    @Column(length = 9, nullable = false)
    private String cTelefono;
    
    @NotNull(message = "El campo foto no debe ser nulo")
    @NotEmpty(message = "El campo foto no debe estar vacio")
    @Column(length = 150)
    private String cFoto;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtFechaReg;
}
