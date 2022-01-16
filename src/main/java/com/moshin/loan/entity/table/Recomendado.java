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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recomendado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recomendado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nId;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cDni", nullable = false)
    private Cliente cliente;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cDniRec", nullable = false)
    private Cliente clienteRec;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "cRuc", nullable = false)
    private Empresa empresa;
    
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dtFechaReg;
    
    @Column(nullable = false)
    private boolean bActivo;
}
