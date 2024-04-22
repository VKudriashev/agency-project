package com.agency.testproject.dao.mappers;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class DeletePatient extends SqlUpdate {

    public DeletePatient(DataSource ds) {
        super(ds, "DELETE FROM patient WHERE ID=:id");
        declareParameter(new SqlParameter("id", Types.VARCHAR));
    }
}
