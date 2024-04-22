package com.agency.testproject.dao.mappers;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class CreatePatient extends SqlUpdate {

    public CreatePatient(DataSource ds) {
        super(ds, "INSERT INTO Patient(name, gender, birth_date) VALUES (:name, :gender, :birth_date)");
        declareParameter(new SqlParameter("name", Types.VARCHAR));
        declareParameter(new SqlParameter("gender", Types.VARCHAR));
        declareParameter(new SqlParameter("birth_date", Types.DATE));
        setGeneratedKeysColumnNames("id");
        setReturnGeneratedKeys(true);
    }
}
