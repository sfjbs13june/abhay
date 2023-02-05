package com.abhay.com.model;

import org.springframework.stereotype.Component;

@Component
public class Patient {

    String patid;
    String name;
    String age;
    String gender;
    String disease;


    public Patient(){


    }
    public Patient(String patid, String name, String age, String gender, String disease) {
        this.patid = patid;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    public void setPatId(String patid) {
        this.patid = patid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }


    public String getPatId() {
        return patid;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDisease() {
        return disease;
    }






}
