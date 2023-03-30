
package com.usuarios.usuarios.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transporte", schema="public")
public class Transporte {
    private  String matricula;
    private Integer modelo;
    private String numero_ejes;
    private String marca;
    private Integer estado;
    private Integer pesaje_mercaderia;
    private Date fecha_inscripcion ;

    public Transporte() {
    }

    public Transporte(String matricula, Integer modelo, String numero_ejes, String marca, Integer estado, Integer pesaje_mercaderia, Date fecha_inscripcion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.numero_ejes = numero_ejes;
        this.marca = marca;
        this.estado = estado;
        this.pesaje_mercaderia = pesaje_mercaderia;
        this.fecha_inscripcion = fecha_inscripcion;
    }

    @Id
    @Column (name="matricula", length=13)
    public String getMatricula() {
        return matricula;
    }

    @Column (name="modelo", length=30)
    public Integer getModelo() {
        return modelo;
    }

    @Column (name="numero_ejes", length=30)
    public String getNumero_ejes() {
        return numero_ejes;
    }

    @Column (name="marca", length=30)
    public String getMarca() {
        return marca;
    }

    @Column (name="estado", length=30)
    public Integer getEstado() {
        return estado;
    }

    @Column (name="pesaje_mercaderia", length=30)
    public Integer getPesaje_mercaderia() {
        return pesaje_mercaderia;
    }

    @Column (name="fecha_inscripcion", length=30)
    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public void setNumero_ejes(String numero_ejes) {
        this.numero_ejes = numero_ejes;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public void setPesaje_mercaderia(Integer pesaje_mercaderia) {
        this.pesaje_mercaderia = pesaje_mercaderia;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }
    
    
}
