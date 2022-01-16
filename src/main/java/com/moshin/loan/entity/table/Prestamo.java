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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prestamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cDni", nullable = false)
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cRuc", nullable = false)
    private Empresa empresa;

    @Min( message = "El campo monto no debe ser menor a 1", value = 1)
    @Column(nullable = false)
    private double nMonto;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "El campo fecha inicial no debe ser nulo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date dtFechaIni;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "El campo fecha final no debe ser nulo")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date dtFechaFin;

    @Column(nullable = false)
    private boolean bActivo;
 
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "nIdTipoPrestamo", nullable = false)
    private TipoPrestamo tipoPrestamo;
}
