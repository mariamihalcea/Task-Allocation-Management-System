/** Clasa pentru Client
 * @author Mihalcea Maria-Alexandra 331AA
 * @version 17 Decembrie 2024
 */
package com.example.proiectawj.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idClient;

    @Column(nullable = false)
    private String nume;

    @Column(nullable = false)
    private String prenume;

    @Column(nullable = false)
    private String adresa;

    @Column(nullable = false)
    private String telefon;

    @Column(nullable = false)
    private String email;

    // Constructor fără parametri
    public Client() {}

    // Constructor cu parametri
    public Client(Integer idClient, String nume, String prenume, String adresa, String telefon, String email) {
        this.idClient = idClient;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }

    // Getteri și setteri
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getNume() {
        return nume;
    }



    public String getPrenume() {
        return prenume;
    }


    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setNume(String nume) {
        if (!nume.matches("^[A-Z][a-z]+$")) {
            throw new IllegalArgumentException("Numele trebuie să înceapă cu literă mare și să conțină doar litere.");
        }
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        if (!prenume.matches("^[A-Z][a-z]+$")) {
            throw new IllegalArgumentException("Prenumele trebuie să înceapă cu literă mare și să conțină doar litere.");
        }
        this.prenume = prenume;
    }

    public void setTelefon(String telefon) {
        if (!telefon.matches("^\\d+$")) {
            throw new IllegalArgumentException("Telefonul trebuie să conțină doar cifre.");
        }
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Metode suplimentare: equals, hashCode și toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(idClient, client.idClient) &&
                Objects.equals(nume, client.nume) &&
                Objects.equals(prenume, client.prenume) &&
                Objects.equals(adresa, client.adresa) &&
                Objects.equals(telefon, client.telefon) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, nume, prenume, adresa, telefon, email);
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
