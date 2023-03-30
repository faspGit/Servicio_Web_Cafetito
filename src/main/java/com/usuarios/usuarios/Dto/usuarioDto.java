
package com.usuarios.usuarios.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class usuarioDto {
    private Integer idUsuario ;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private Integer edad;
    private Integer telefono;
    private String direccion;
}
