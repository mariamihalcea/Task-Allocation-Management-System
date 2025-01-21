/** Controller pentru Serviciu
 * @author Mihalcea Maria-Alexandra 331AA
 * @version 17 Decembrie 2024
 */
package com.example.proiectawj.controller;

import com.example.proiectawj.entity.Serviciu;
import com.example.proiectawj.repository.ServiciuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ServiciuController {

    @Autowired
    private ServiciuRepository serviciuRepository;

    // Listarea serviciilor pe care le am disponibile
    @GetMapping("/services")
    public String listServices(Model model) {
        List<Serviciu> servicii = serviciuRepository.findAll();
        model.addAttribute("servicii", servicii);
        return "listareServicii";  // Redirecționează către pagina cu lista serviciilor
    }

    // Formular pt adaugarea unui nou serviciu
    @GetMapping("/services/add")
    public String showAddServiceForm() {
        return "adaugareServiciu";
    }

    // Salvare serviciu
    @PostMapping("/services/add")
    public String addService(@RequestParam String denumire,
                             @RequestParam String descriere,
                             @RequestParam Double pret,
                             Model model) {
        Serviciu serviciu = new Serviciu();
        serviciu.setDenumire(denumire);
        serviciu.setDescriere(descriere);
        serviciu.setPret(pret);

        serviciuRepository.save(serviciu);

        List<Serviciu> servicii = serviciuRepository.findAll();
        model.addAttribute("servicii", servicii);

        return "listareServicii";
    }

    @PostMapping("/services/delete")
    public String deleteService(@RequestParam Integer idServiciu, Model model) {
        if (serviciuRepository.existsById(idServiciu)) {
            serviciuRepository.deleteById(idServiciu);
        } else {
            // Mesaj de eroare in caz ca serviciul nu exista
            model.addAttribute("error", "Serviciul nu a fost găsit.");
        }

        List<Serviciu> servicii = serviciuRepository.findAll();
        model.addAttribute("servicii", servicii);

        return "listareServicii";
    }
}
