/** Controller pentru Angajat
 * @author Mihalcea Maria-Alexandra 331AA
 * @version 17 Decembrie 2024
 */
package com.example.proiectawj.controller;

import com.example.proiectawj.entity.Angajat;
import com.example.proiectawj.repository.AngajatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AngajatController {

    @Autowired
    private AngajatRepository angajatRepository;

    // afisez lista cu angajatii din baza mea de date
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        List<Angajat> angajati = angajatRepository.findAll();
        model.addAttribute("angajati", angajati);
        return "listareAngajati";
    }

    // afisare formular pt adaugarea unui nou angajat
    @GetMapping("/employees/add")
    public String showAddEmployeeForm() {
        return "adaugareAngajat";
    }

    // salvare anagajat nou
    @PostMapping("/employees/add")
    public String addEmployee(@RequestParam String employeeName,
                              @RequestParam String employeeSurname,
                              @RequestParam String specialization,
                              @RequestParam String email,
                              @RequestParam Boolean availability,
                              Model model) {
        boolean hasErrors = false;

        if (!employeeName.matches("^[A-Z][a-z]+$")) {
            model.addAttribute("errorNume", "Numele trebuie să înceapă cu literă mare și să conțină doar litere.");
            hasErrors = true;
        }

        if (!employeeSurname.matches("^[A-Z][a-z]+$")) {
            model.addAttribute("errorPrenume", "Prenumele trebuie să înceapă cu literă mare și să conțină doar litere.");
            hasErrors = true;
        }


        if (hasErrors) {
            return "adaugareAngajat";
        }

        Angajat angajat = new Angajat();
        angajat.setNume(employeeName);
        angajat.setPrenume(employeeSurname);
        angajat.setSpecializare(specialization);
        angajat.setEmail(email);
        angajat.setDisponibilitate(availability);

        angajatRepository.save(angajat);


        List<Angajat> angajati = angajatRepository.findAll();
        model.addAttribute("angajati", angajati);

        return "listareAngajati";
    }
    // deschidere formular pentru editarea unui angajat
    @GetMapping("/employees/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Integer id, Model model) {
        Optional<Angajat> angajatOpt = angajatRepository.findById(id);

        if (angajatOpt.isPresent()) {
            Angajat angajat = angajatOpt.get();
            model.addAttribute("angajat", angajat);
            return "editareAngajat";
        }

        return "redirect:/";
    }

    // salvarea modificarilor facute pt un angajat
    @PostMapping("/employees/edit")
    public String editEmployee(@RequestParam Integer employeeId,
                               @RequestParam String employeeName,
                               @RequestParam String employeeSurname,
                               @RequestParam String specialization,
                               @RequestParam String email,
                               @RequestParam Boolean availability,
                               Model model) {

        Optional<Angajat> angajatOpt = angajatRepository.findById(employeeId);

        if (angajatOpt.isPresent()) {
            Angajat angajat = angajatOpt.get();
            angajat.setNume(employeeName);
            angajat.setPrenume(employeeSurname);
            angajat.setSpecializare(specialization);
            angajat.setEmail(email);
            angajat.setDisponibilitate(availability);

            angajatRepository.save(angajat);
        }

        List<Angajat> angajati = angajatRepository.findAll();
        model.addAttribute("angajati", angajati);

        return "listareAngajati";
    }

    // Stergerea unui angajat
    @PostMapping("/employees/delete")
    public String deleteEmployee(@RequestParam Integer employeeId, Model model) {
        angajatRepository.deleteById(employeeId);

        List<Angajat> angajati = angajatRepository.findAll();
        model.addAttribute("angajati", angajati);

        return "listareAngajati";
    }
}