package com.example.proiectawj.repository;

import com.example.proiectawj.entity.Angajat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AngajatRepository extends JpaRepository<Angajat, Integer> {
    // caut angajati dupa nume
    List<Angajat> findByNume(String nume);
}
