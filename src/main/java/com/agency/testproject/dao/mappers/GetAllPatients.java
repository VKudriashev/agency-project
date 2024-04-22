package com.agency.testproject.dao.mappers;

import javax.sql.DataSource;

public class GetAllPatients extends GetPatient {

    public GetAllPatients(DataSource ds) {
        super(ds, "SELECT ID, NAME, GENDER, BIRTH_DATE FROM Patient");
    }
}
