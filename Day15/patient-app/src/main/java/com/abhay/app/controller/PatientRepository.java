package com.abhay.app.controller;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {

    public Patient findByName(String name);
    public Patient findBypatId(String patid);
    public void deleteByname(String name);
    public Patient save(Patient patient);

}