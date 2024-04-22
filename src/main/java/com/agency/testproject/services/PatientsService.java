package com.agency.testproject.services;

import com.agency.testproject.model.Patient;

import java.util.List;

public interface PatientsService {

    List<Patient> getAll();

    Patient getById(String uuid);

    Patient create(Patient patient);

    Patient update(Patient patient);

    void delete(String uuid);
}
