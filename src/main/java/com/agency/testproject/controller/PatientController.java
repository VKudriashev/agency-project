package com.agency.testproject.controller;

import com.agency.testproject.model.Patient;
import com.agency.testproject.services.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patients")
public class PatientController {

    private final PatientsService patientsService;

    @Autowired
    public PatientController(PatientsService patientsService) {
        this.patientsService = patientsService;
    }

    @GetMapping
    public List<Patient> getAll() {
        return patientsService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Patient getById(@PathVariable String id) {
        return patientsService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient create(@RequestBody Patient patient) {
        return patientsService.create(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient) {
        return patientsService.update(patient);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        patientsService.delete(id);
    }
}
