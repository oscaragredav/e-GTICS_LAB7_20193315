package com.example.lab7.controller;

import com.example.lab7.repository.SiteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticasController {

    final SiteRepository siteRepository;

    public EstadisticasController(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    @GetMapping(value = {"", "/", "/lista"})
    public String listarEmpleados(Model model) {
        model.addAttribute("lista", siteRepository.obtenerTicketPorSitio());
        return "estadisticas/lista";
    }
}
