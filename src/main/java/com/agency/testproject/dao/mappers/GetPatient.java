package com.agency.testproject.dao.mappers;

import com.agency.testproject.model.Patient;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class GetPatient extends MappingSqlQuery<Patient> {

    public GetPatient(DataSource ds, String sql) {
        super(ds, sql);
    }

    @Override
    protected Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
        Patient singer = new Patient();
        singer.setId(UUID.fromString(rs.getString("id")));
        singer.setName(rs.getString("name"));
        singer.setGender(rs.getString("gender"));
        singer.setBirthDate(rs.getDate("birth_date"));
        return singer;
    }
}
