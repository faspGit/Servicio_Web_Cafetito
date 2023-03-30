
package com.usuarios.usuarios.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pesajePesoCabal", schema="public")
public class pesajePesoCabal {
    private String idCuenta ;
    private String primerPesaje;
    private String pesajeParcial;
    private String ultimoPesaje;
    private String pesoMarcado;

    public pesajePesoCabal() {
    }

    public pesajePesoCabal(String idCuenta, String primerPesaje, String pesajeParcial, String ultimoPesaje, String pesoMarcado) {
        this.idCuenta = idCuenta;
        this.primerPesaje = primerPesaje;
        this.pesajeParcial = pesajeParcial;
        this.ultimoPesaje = ultimoPesaje;
        this.pesoMarcado = pesoMarcado;
    }
    @Id
    @Column (name="idCuenta", length=10)
    public String getIdCuenta() {
        return idCuenta;
    }

    @Column (name="primerPesaje", length=10)
    public String getPrimerPesaje() {
        return primerPesaje;
    }

    @Column (name="pesajeParcial", length=10)
    public String getPesajeParcial() {
        return pesajeParcial;
    }

    @Column (name="ultimoPesaje", length=10)
    public String getUltimoPesaje() {
        return ultimoPesaje;
    }
    
    @Column (name="pesoMarcado", length=10)
    public String getPesoMarcado() {
        return pesoMarcado;
    }
    
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setPrimerPesaje(String primerPesaje) {
        this.primerPesaje = primerPesaje;
    }

    public void setPesajeParcial(String pesajeParcial) {
        this.pesajeParcial = pesajeParcial;
    }

    public void setUltimoPesaje(String ultimoPesaje) {
        this.ultimoPesaje = ultimoPesaje;
    }

    public void setPesoMarcado(String pesoMarcado) {
        this.pesoMarcado = pesoMarcado;
    }

    
}
