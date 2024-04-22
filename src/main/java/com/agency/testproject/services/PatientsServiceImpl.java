package com.agency.testproject.services;

import com.agency.testproject.dao.PatientsDao;
import com.agency.testproject.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsServiceImpl implements PatientsService {

    private final PatientsDao patientsDao;

    public PatientsServiceImpl(PatientsDao patientsDao) {
        this.patientsDao = patientsDao;
    }

    @Override
    public List<Patient> getAll() {
        return patientsDao.getAll();
    }

    @Override
    public Patient getById(String uuid) {
        return patientsDao.getById(uuid);
    }

    @Override
    public Patient create(Patient patient) {
        return patientsDao.create(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return patientsDao.update(patient);
    }

    @Override
    public void delete(String uuid) {
        patientsDao.delete(uuid);
    }
}
