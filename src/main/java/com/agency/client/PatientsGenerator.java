package com.agency.client;

import com.agency.testproject.model.Patient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@PropertySource("classpath:application.yml")
public class PatientsGenerator {

    private final Properties properties;
    private final RestTemplate restTemplate;

    private String token;

    public PatientsGenerator() {
        this.restTemplate = new RestTemplate();
        this.properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/application.yml"));
        } catch (IOException e) {
            System.out.println("Resources load failed");
        }
    }

    public void generatePatients() {
        List<Patient> patients = PatientsListGenerator.generatePatientsList(100);
        extractAccessToken();
        addPatients(patients);
        // getPatients();
    }

    private void extractAccessToken() {
        String url = properties.getProperty("token-url");

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("client_id", properties.getProperty("client-id"));
        body.add("client_secret", properties.getProperty("client-secret"));
        body.add("username", properties.getProperty("username"));
        body.add("password", properties.getProperty("password"));
        body.add("grant_type", properties.getProperty("grant-type"));

        ResponseEntity<TokenData> response = restTemplate.postForEntity(url, body, TokenData.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            token = Optional.ofNullable(response.getBody()).map(data -> data.access_token).orElse(null);
        }
    }

    private void getPatients() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        ResponseEntity<Patient[]> response = restTemplate.exchange(properties.getProperty("patients-url"),
                HttpMethod.GET, new HttpEntity<>(headers), Patient[].class);
        System.out.println(Arrays.toString(response.getBody()));
    }

    private void addPatients(List<Patient> patients) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);

        String url = properties.getProperty("patients-url");
        patients.forEach(patient -> restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(patient, headers), String.class));
    }

    private static class TokenData {

        public String access_token;

        public TokenData() {
        }
    }

    public static void main(String[] args) {
        new PatientsGenerator().generatePatients();
    }
}
