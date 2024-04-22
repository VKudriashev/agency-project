package com.agency.testproject.dao.mappers;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdatePatient extends SqlUpdate {

    public UpdatePatient(DataSource ds) {
        super(ds, "UPDATE Patient SET NAME=:name, GENDER=:gender, BIRTH_DATE=:birth_date WHERE ID=:id");
        declareParameter(new SqlParameter("name", Types.VARCHAR));
        declareParameter(new SqlParameter("gender", Types.VARCHAR));
        declareParameter(new SqlParameter("birth_date", Types.DATE));
        declareParameter(new SqlParameter("id", Types.VARCHAR));
    }
}
