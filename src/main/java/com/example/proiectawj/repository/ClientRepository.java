package com.example.proiectawj.repository;

import com.example.proiectawj.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
