package com.example.proiectawj.controller;
import com.example.proiectawj.entity.Angajat;
import org.springframework.ui.Model;
import com.example.proiectawj.repository.AngajatRepository;
import com.example.proiectawj.repository.ClientRepository;
import com.example.proiectawj.repository.ServiciuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AngajatRepository angajatRepository;

    @Autowired
    private ServiciuRepository serviciuRepository;

    @GetMapping("/")
    public String showHomePage() {
        return "index";  // Pagina principală cu butoane
    }


}
