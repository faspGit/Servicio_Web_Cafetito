
package com.usuarios.usuarios.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Usuario", schema="public")
public class usuario {
    private Integer idUsuario ;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private Integer edad;
    private Integer telefono;
    private String direccion;

    public usuario() {
    }

    public usuario(Integer idUsuario, String nombre, String apellido, String contrasena, String correo, Integer edad, Integer telefono, String direccion) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.edad = edad;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    
    @Id
    @Column (name="id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    @Column (name="nombre", length=50)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column (name="apellido", length=50)
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    @Column (name="contrasena", length=11)
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    @Column( name = "correo" , length = 50)
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    @Column(name = "edad" )
    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Column(name = "telefono")
    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Column(name = "direccion", length=50)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
