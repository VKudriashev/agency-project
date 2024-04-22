package com.agency.testproject.dao.mappers;

import org.springframework.jdbc.core.SqlParameter;

import javax.sql.DataSource;
import java.sql.Types;

public class GetPatientById extends GetPatient {

    public GetPatientById(DataSource ds) {
        super(ds, "SELECT ID, NAME, GENDER, BIRTH_DATE FROM Patient WHERE ID=:id");
        declareParameter(new SqlParameter("id", Types.VARCHAR));
    }
}
