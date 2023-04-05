
package com.usuarios.usuarios.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transporte", schema="public")
public class Transporte {
    
    private String matricula;
    private Integer modelo;
    private String numero_ejes;
    private String marca;
    private Integer estado;
    private String color;
    private Integer peso_de_camion;
    private Integer peso_de_mercaderia;
    private Date fecha_inscripcion ;
    private String fecha_modificacion;

    public Transporte() {
    }

    public Transporte(String matricula, Integer modelo, String numero_ejes, String marca, Integer estado, String color, Integer peso_de_camion, Integer peso_de_mercaderia, Date fecha_inscripcion, String fecha_modificacion) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.numero_ejes = numero_ejes;
        this.marca = marca;
        this.estado = estado;
        this.color = color;
        this.peso_de_camion = peso_de_camion;
        this.peso_de_mercaderia = peso_de_mercaderia;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_modificacion = fecha_modificacion;
    }

    @Id
    @Column (name="matricula", length=13)
    public String getMatricula() {
        return matricula;
    }

    @Column (name="modelo")
    public Integer getModelo() {
        return modelo;
    }

    @Column (name="numero_ejes", length=13)
    public String getNumero_ejes() {
        return numero_ejes;
    }

    @Column (name="marca", length=13)
    public String getMarca() {
        return marca;
    }

    @Column (name="estado")
    public Integer getEstado() {
        return estado;
    }

    @Column (name="color", length=13)
    public String getColor() {
        return color;
    }

    @Column (name="peso_de_camion")
    public Integer getPeso_de_camion() {
        return peso_de_camion;
    }

    @Column (name="peso_de_mercaderia")
    public Integer getPeso_de_mercaderia() {
        return peso_de_mercaderia;
    }

    @Column (name="fecha_inscripcion")
    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    @Column (name="fecha_modificacion", length=13)
    public String getFecha_modificacion() {
        return fecha_modificacion;
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

    public void setColor(String color) {
        this.color = color;
    }

    public void setPeso_de_camion(Integer peso_de_camion) {
        this.peso_de_camion = peso_de_camion;
    }

    public void setPeso_de_mercaderia(Integer peso_de_mercaderia) {
        this.peso_de_mercaderia = peso_de_mercaderia;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public void setFecha_modificacion(String fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    
   
    
}
