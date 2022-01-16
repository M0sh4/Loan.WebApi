package com.moshin.loan.entity.table;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cDni", nullable = false)
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cRuc", nullable = false)
    private Empresa empresa;

    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotEmpty(message = "El campo nombre no puede estar vacio")
    @Column(length = 150, nullable = false)
    private String cNombre;

    @Column(nullable = false)
    @JsonFormat( pattern = "yyyy-MM-dd")
    private Date dtFechaReg;

    @Column(nullable = false)
    private boolean bActivo;
}
