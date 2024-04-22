package com.agency.testproject.controller;

import com.agency.client.PatientsGenerator;
import com.agency.testproject.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class PatientViewController {

    private final PatientsService patientsService;

    @Autowired
    public PatientViewController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping(value = "/patients/v2")
    public String getAll(Principal principal, Model model) {
        model.addAttribute("patients", patientsService.getAll());
        model.addAttribute("username", principal.getName());
        return "patients";
    }

    @GetMapping("/access-denied")
    public String showAccessDeniedPage() {
        return "access-denied";
    }

    @GetMapping(value = "/patients/generate")
    @ResponseBody
    public String generatePatients() {
        new PatientsGenerator().generatePatients();
        return "Patients generated!";
    }
}
