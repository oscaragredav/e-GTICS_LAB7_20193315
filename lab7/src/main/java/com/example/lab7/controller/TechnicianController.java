package com.example.lab7.controller;

import com.example.lab7.entity.Technician;
import com.example.lab7.repository.TechnicianRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/tecnico")
public class TechnicianController {

    final TechnicianRepository technicianRepository;


    public TechnicianController(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    @GetMapping(value = {"/lista"})
    public String lista(Model model){

        model.addAttribute("listaTecnico", technicianRepository.findAll());

        return "tecnico/lista";
    }

    @GetMapping("/nuevo")
    public String nuevoTecnico(Model model, @ModelAttribute("tecnico") Technician technician) {
        return "tecnico/form";
    }
    @GetMapping("/editar")
    public String editarTecnico(@ModelAttribute("tecnico") Technician technician,
                                      Model model, @RequestParam("id") int id) {

        Optional<Technician> optionalTechnician = technicianRepository.findById(id);

        if (optionalTechnician.isPresent()) {
            technician = optionalTechnician.get();
            model.addAttribute("tecnico", technician);

            return "tecnico/form";
        } else {
            return "redirect:/tecnicos/lista";
        }
    }

    @PostMapping("/save")
    public String guardarProducto(RedirectAttributes attr, Model model,
                                  @ModelAttribute("tecnico") @Valid Technician technician, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { //si no hay errores, se realiza el flujo normal

            if (technician.getId() == null) {
                attr.addFlashAttribute("msg", "Técnico"+ technician.getFirstname() + " " + technician.getLastname() + " " + "creado exitosamente");
            } else {
                attr.addFlashAttribute("msg", "Técnico"+ technician.getFirstname() + " " + technician.getLastname() + " " + "actualizado exitosamente");
            }

            technicianRepository.save(technician);
            return "redirect:/tecnico/lista";

        } else { //hay al menos 1 error
            return "tecnico/form";
        }
    }




}
