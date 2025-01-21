/** Clasa pentru Angajat
 * @author Mihalcea Maria-Alexandra 331AA
 * @version 17 Decembrie 2024
 */
package com.example.proiectawj.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAngajat;

    @Column(nullable = false)
    private String nume;

    @Column(nullable = false)
    private String prenume;

    @Column(nullable = false)
    private String specializare;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Boolean disponibilitate;

    // Constructor fără parametri
    public Angajat() {}

    // Constructor cu parametri
    public Angajat(Integer idAngajat, String nume, String prenume, String specializare, String email, Boolean disponibilitate) {
        this.idAngajat = idAngajat;
        this.nume = nume;
        this.prenume = prenume;
        this.specializare = specializare;
        this.email = email;
        this.disponibilitate = disponibilitate;
    }

    // Getteri și setteri
    public Integer getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Integer idAngajat) {
        this.idAngajat = idAngajat;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getDisponibilitate() {
        return disponibilitate;
    }

    public void setDisponibilitate(Boolean disponibilitate) {
        this.disponibilitate = disponibilitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Angajat angajat = (Angajat) o;
        return Objects.equals(idAngajat, angajat.idAngajat) &&
                Objects.equals(nume, angajat.nume) &&
                Objects.equals(prenume, angajat.prenume) &&
                Objects.equals(specializare, angajat.specializare) &&
                Objects.equals(email, angajat.email) &&
                Objects.equals(disponibilitate, angajat.disponibilitate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAngajat, nume, prenume, specializare, email, disponibilitate);
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "idAngajat=" + idAngajat +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", specializare='" + specializare + '\'' +
                ", email='" + email + '\'' +
                ", disponibilitate=" + disponibilitate +
                '}';
    }
}
