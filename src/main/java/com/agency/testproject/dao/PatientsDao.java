package com.agency.testproject.dao;

import com.agency.testproject.model.Patient;

import java.util.List;

public interface PatientsDao {

    List<Patient> getAll();

    Patient getById(String id);

    Patient create(Patient patient);

    Patient update(Patient patient);

    void delete(String uuid);
}
