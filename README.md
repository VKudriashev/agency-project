## OAuth2 authorization REST-service with Keycloak

---

The test app is available at http://localhost:8080.

The keycloak for admin access is available at http://localhost:8180 or http://10.5.0.1:8180/.

**Keycloak admin:**

**Username:** admin; **Password:** keycloak

---

**_It may be necessary to create/recreate "Practitioner"(with "ROLE_PRACTITIONER" role assignment)
and "Patient"(with "ROLE_PATIENT" role assignment) users in Keycloak. You can do this by logging in as admin._**

---

**User with "Patient" role:**

**Username:** patient; **Password:** patPass

Access to: 

1. GET:/patients
2. GET:/patients/v2
3. GET:/patients/{id}

---

**User with "Practitioner" role:**

**Username:** practitioner; **Password:** practPass

Access to:

1. GET:/patients
2. GET:/patients/v2
3. GET:/patients/generate - generate test patients data
4. GET:/patients/{id} 
5. POST:/patients - add new patient 
6. PUT:/patients - update patient 
7. DELETE:/patients/{id}

---