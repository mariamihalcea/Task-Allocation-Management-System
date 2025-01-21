/** Controller pentru Client
 * @author Mihalcea Maria-Alexandra 331AA
 * @version 17 Decembrie 2024
 */
package com.example.proiectawj.controller;

import com.example.proiectawj.entity.Client;
import com.example.proiectawj.repository.ClientRepository;
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
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    //Lista clientilor din baza mea de date
    @GetMapping("/clients")
    public String listClients(Model model) {
        List<Client> clienti = clientRepository.findAll();
        model.addAttribute("clienti", clienti);
        return "listareClienti";
    }

    // Formular pt adaugare client
    @GetMapping("/clients/add")
    public String showAddClientForm() {
        return "adaugareClient";
    }

    //  adaugare client nou
    @PostMapping("/clients/add")
    public String addClient(@RequestParam String clientName,
                            @RequestParam String clientSurname,
                            @RequestParam String address,
                            @RequestParam String phone,
                            @RequestParam String email,
                            Model model) {
        boolean hasErrors = false;

        if (!clientName.matches("^[A-Z][a-z]+$")) {
            model.addAttribute("errorNume", "Numele trebuie să înceapă cu literă mare și să conțină doar litere.");
            hasErrors = true;
        }

        if (!clientSurname.matches("^[A-Z][a-z]+$")) {
            model.addAttribute("errorPrenume", "Prenumele trebuie să înceapă cu literă mare și să conțină doar litere.");
            hasErrors = true;
        }

        if (!phone.matches("^\\d+$")) {
            model.addAttribute("errorTelefon", "Telefonul trebuie să conțină doar cifre.");
            hasErrors = true;
        }

        if (hasErrors) {
            return "adaugareClient";
        }

        Client client = new Client();
        client.setNume(clientName);
        client.setPrenume(clientSurname);
        client.setAdresa(address);
        client.setTelefon(phone);
        client.setEmail(email);

        clientRepository.save(client);

        model.addAttribute("clienti", clientRepository.findAll());
        return "listareClienti";
    }

    // editarea unui client
    @GetMapping("/clients/edit/{id}")
    public String showEditClientForm(@PathVariable Integer id, Model model) {
        Optional<Client> clientOpt = clientRepository.findById(id);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            model.addAttribute("client", client);
            return "editareClient";
        }

        return "redirect:/";
    }

    // Salvarea modificarilor facute
    @PostMapping("/clients/edit")
    public String editClient(@RequestParam Integer clientId,
                             @RequestParam String clientName,
                             @RequestParam String clientSurname,
                             @RequestParam String address,
                             @RequestParam String phone,
                             @RequestParam String email,
                             Model model) {

        Optional<Client> clientOpt = clientRepository.findById(clientId);

        if (clientOpt.isPresent()) {
            Client client = clientOpt.get();
            client.setNume(clientName);
            client.setPrenume(clientSurname);
            client.setAdresa(address);
            client.setTelefon(phone);
            client.setEmail(email);

            clientRepository.save(client);
        }

        List<Client> clienti = clientRepository.findAll();
        model.addAttribute("clienti", clienti);

        return "listareClienti";
    }

    // Stergere client
    @PostMapping("/clients/delete")
    public String deleteClient(@RequestParam Integer clientId, Model model) {
        clientRepository.deleteById(clientId);

        List<Client> clienti = clientRepository.findAll();
        model.addAttribute("clienti", clienti);

        return "listareClienti";
    }
}
