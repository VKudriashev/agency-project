package com.agency.testproject.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

public class Patient implements Serializable {

    private UUID id;
    private String name;
    private String gender;
    private Date birthDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Patient - Id: " + id +
                ", Name: " + name +
                ", Gender: " + gender +
                ", Birthday:" + birthDate;
    }
}
