package com.usuarios.usuarios.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class pesajePesoCabalDto {
    private String idCuenta ;
    private String primerPesaje;
    private String pesajeParcial;
    private String ultimoPesaje;
    private String pesoMarcado;
 }
