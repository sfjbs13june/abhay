package com.abhay.app.controller;

import com.abhay.app.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {

    public Hospital findByName(String name);
    public Hospital findByHosId(String hosId);
    public void deleteByName(String name);
    public Hospital save(Hospital hospital);

}