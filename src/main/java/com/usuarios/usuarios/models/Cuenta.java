/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.usuarios.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author fasp9
 */
@Entity
@Table(name="Cuenta", schema="public")
public class Cuenta {
    
    private Integer id_cuenta;
    private String estado_cuenta;
    private Integer peso_total_de_envio;
    private Integer numero_parcialidades;
    private String matriculas_autorizadas;
    private String nit_agricultor;
    private Integer numero_pesajes_registrados;
    private Date fecha_creacion;
    private Date fecha_modificacion;

    public Cuenta() {
    }

    public Cuenta(Integer id_cuenta, String estado_cuenta, Integer peso_total_de_envio, Integer numero_parcialidades, String matriculas_autorizadas, String nit_agricultor, Integer numero_pesajes_registrados, Date fecha_creacion, Date fecha_modificacion) {
        this.id_cuenta = id_cuenta;
        this.estado_cuenta = estado_cuenta;
        this.peso_total_de_envio = peso_total_de_envio;
        this.numero_parcialidades = numero_parcialidades;
        this.matriculas_autorizadas = matriculas_autorizadas;
        this.nit_agricultor = nit_agricultor;
        this.numero_pesajes_registrados = numero_pesajes_registrados;
        this.fecha_creacion = fecha_creacion;
        this.fecha_modificacion = fecha_modificacion;
        
    }

    @Id
    @Column (name="id_cuenta", length=30)
    public Integer getId_cuenta() {
        return id_cuenta;
    }

    @Column (name="estado_cuenta", length=30)
    public String getEstado_cuenta() {
        return estado_cuenta;
    }

    @Column (name="peso_total_de_envio")
    public Integer getPeso_total_de_envio() {
        return peso_total_de_envio;
    }

    @Column (name="numero_parcialidades")
    public Integer getNumero_parcialidades() {
        return numero_parcialidades;
    }

    @Column (name="matriculas_autorizadas", length=50)
    public String getMatriculas_autorizadas() {
        return matriculas_autorizadas;
    }

    @Column (name="nit_agricultor", length=13)
    public String getNit_agricultor() {
        return nit_agricultor;
    }

    @Column (name="numero_pesajes_registrados")
    public Integer getNumero_pesajes_registrados() {
        return numero_pesajes_registrados;
    }

    @Column (name="fecha_creacion")
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

     @Column (name="fecha_modificacion")
    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setId_cuenta(Integer id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public void setEstado_cuenta(String estado_cuenta) {
        this.estado_cuenta = estado_cuenta;
    }

    public void setPeso_total_de_envio(Integer peso_total_de_envio) {
        this.peso_total_de_envio = peso_total_de_envio;
    }

    public void setNumero_parcialidades(Integer numero_parcialidades) {
        this.numero_parcialidades = numero_parcialidades;
    }

    public void setMatriculas_autorizadas(String matriculas_autorizadas) {
        this.matriculas_autorizadas = matriculas_autorizadas;
    }

    public void setNit_agricultor(String nit_agricultor) {
        this.nit_agricultor = nit_agricultor;
    }

    public void setNumero_pesajes_registrados(Integer numero_pesajes_registrados) {
        this.numero_pesajes_registrados = numero_pesajes_registrados;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }
    
    
}
