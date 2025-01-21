/** Clasa pentru Serviciu
 * @author Mihalcea Maria-Alexandra 331AA
 * @version 17 Decembrie 2024
 */
package com.example.proiectawj.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Serviciu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServiciu;

    @Column(nullable = false)
    private String denumire;

    private String descriere;

    @Column(nullable = false)
    private Double pret;

    // Constructor fără parametri
    public Serviciu() {}

    // Constructor cu parametri
    public Serviciu(Integer idServiciu, String denumire, String descriere, Double pret) {
        this.idServiciu = idServiciu;
        this.denumire = denumire;
        this.descriere = descriere;
        this.pret = pret;
    }


    // Getteri și setteri
    public Integer getIdServiciu() {
        return idServiciu;
    }

    public void setIdServiciu(Integer idServiciu) {
        this.idServiciu = idServiciu;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    // Metode suplimentare: equals, hashCode și toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serviciu serviciu = (Serviciu) o;
        return Objects.equals(idServiciu, serviciu.idServiciu) &&
                Objects.equals(denumire, serviciu.denumire) &&
                Objects.equals(descriere, serviciu.descriere) &&
                Objects.equals(pret, serviciu.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idServiciu, denumire, descriere, pret);
    }

    @Override
    public String toString() {
        return "Serviciu{" +
                "idServiciu=" + idServiciu +
                ", denumire='" + denumire + '\'' +
                ", descriere='" + descriere + '\'' +
                ", pret=" + pret +
                '}';
    }
}
