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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_prestamo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;

    @NotNull(message = "El campo procentaje no debe ser nulo")
    @Min(message = "EL campo porcentaje debe ser mayor a 0", value = 1)
    @Max(message = "El campo porcentaje debe ser menor o igual a 100", value = 100)
    @Column(nullable = false)
    private Integer nPorcentaje;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cRuc", nullable = false)
    private Empresa empresa;

    @NotNull(message = "El campo nombre no debe ser nulo")
    @NotEmpty(message = "El campo nombre no debe estar vacio")
    @Column(length = 150, nullable = false)
    private String cNombre;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtFechaReg;

    @Column(nullable = false)
    private boolean bActivo;
}
