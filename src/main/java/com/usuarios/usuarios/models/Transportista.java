
package com.usuarios.usuarios.models;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Transportista", schema="public")
public class Transportista {
    private String numeroLicencia ; 
    private String nombre; 
    private String apellido; 
    private String tipoLicencia;
    //private Date fechaCreacion;
    private Integer estado;

    public Transportista() {
    }

    public Transportista(String numeroLicencia, String nombre, String apellido, String tipoLicencia,Integer estado) {
        this.numeroLicencia = numeroLicencia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoLicencia = tipoLicencia;
        //this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    @Id
    @Column (name="numeroLicencia", length=13)
    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    @Column (name="nombre", length=30)
    public String getNombre() {
        return nombre;
    }
    
    @Column (name="apellido", length=30)
    public String getApellido() {
        return apellido;
    }

    @Column (name="tipoLicencia", length=1)
    public String getTipoLicencia() {
        return tipoLicencia;
    }

    @Column (name="estado", length=9)
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    
    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }
     
}
