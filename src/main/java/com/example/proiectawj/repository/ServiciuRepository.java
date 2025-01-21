package com.example.proiectawj.repository;

import com.example.proiectawj.entity.Serviciu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiciuRepository extends JpaRepository<Serviciu, Integer> {
    Optional<Serviciu> findByIdServiciu(Integer idServiciu);
}
