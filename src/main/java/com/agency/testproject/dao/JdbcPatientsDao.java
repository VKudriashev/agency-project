package com.agency.testproject.dao;

import com.agency.testproject.dao.mappers.*;
import com.agency.testproject.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Repository
public class JdbcPatientsDao implements PatientsDao {

    private static Logger logger = LoggerFactory.getLogger(JdbcPatientsDao.class);

    private final DataSource dataSource;

    @Autowired
    public JdbcPatientsDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients = new GetAllPatients(dataSource).execute();
        logger.info(patients.size() + " patients retrieved");
        return patients;
    }

    @Override
    public Patient getById(String id) {
        List<Patient> patients = new GetPatientById(dataSource).executeByNamedParam(Collections.singletonMap("id", id));
        logger.info("Patient retrieved with id: " + (patients.isEmpty() ? null : patients.get(0)));
        return patients.isEmpty() ? null : patients.get(0);
    }


    @Override
    public Patient create(Patient patient) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", patient.getName());
        map.put("gender", patient.getGender());
        map.put("birth_date", patient.getBirthDate());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        new CreatePatient(dataSource).updateByNamedParam(map, keyHolder);
        patient.setId(keyHolder.getKeyAs(UUID.class));
        logger.info("New patient created with id: " + patient.getId());
        return patient;
    }

    @Override
    public Patient update(Patient patient) {
        new UpdatePatient(dataSource).updateByNamedParam(new HashMap<>() {
            {
                put("name", patient.getName());
                put("gender", patient.getGender());
                put("birth_date", patient.getBirthDate());
                put("id", patient.getId());
            }
        });
        logger.info("Existing patient updated with id: " + patient.getId());
        return patient;
    }

    @Override
    public void delete(String uuid) {
        new DeletePatient(dataSource).updateByNamedParam(Collections.singletonMap("id", uuid));
        logger.info("Existing patient deleted with id: " + uuid);
    }
}
