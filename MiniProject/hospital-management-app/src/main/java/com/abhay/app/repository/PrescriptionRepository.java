package com.abhay.app.repository;

import com.abhay.app.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription,String> {

    public Prescription save(Prescription prescription);
    public List<Prescription> findByPatientName(String patientName);
}
