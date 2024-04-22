package com.agency.client;

import com.agency.testproject.model.Patient;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PatientsListGenerator {

    private static final String[] nameParts = {"John", "Mi", "Wil", "Da", "Jam", "Rob", "Jo", "Chr",
            "Mat", "Sam", "Ale", "Ben", "Dan", "Ed", "Gre", "Leo", "Ma", "Ni", "Ow", "Pa"};
    private static final String[] lastNamesParts = {"Smi", "Johns", "Wil", "Bro", "Jon", "Mill", "Dav", "Tay",
            "Walk", "Cla", "Smi", "Park", "Whi", "Lee"};

    private static final Random random = new Random();
    private static final HashMap<String, Integer> map = new HashMap<>();

    public static List<Patient> generatePatientsList(int count) {
        map.clear();
        return IntStream.range(0, count).mapToObj(i -> {
            Patient patient = new Patient();
            patient.setGender(random.nextBoolean() ? "male" : "female");
            patient.setName(generateFullName());
            patient.setBirthDate(Date.valueOf(generateRandomDate()));
            return patient;
        }).toList();
    }

    private static String generateFullName() {
        String fullName;
        do {
            fullName = generateName(2, true) + " " + generateName(3, false);
        } while (map.containsKey(fullName));
        map.put(fullName, 1);
        return fullName;
    }

    private static String generateName(int partsCount, boolean firstName) {
        String[] currentArray = firstName ? nameParts : lastNamesParts;
        int firstNameLength = random.nextInt(partsCount) + 1;
        return IntStream.range(0, firstNameLength)
                .mapToObj(i -> currentArray[random.nextInt(currentArray.length)])
                .collect(Collectors.joining());
    }

    private static LocalDate generateRandomDate() {
        long startEpochDay = LocalDate.of(1982, 1, 1).toEpochDay();
        long endEpochDay = LocalDate.of(2010, 12, 31).toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay + 1);
        return LocalDate.ofEpochDay(randomEpochDay);
    }
}
