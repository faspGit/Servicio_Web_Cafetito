package com.usuarios.usuarios.Dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransportistaDto {
    private String numeroLicencia; 
    private String nombre; 
    private String apellido; 
    private String tipoLicencia;
    //private Date fechaCreacion;
}
