package com.abhay.com.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = Patient.class)
public class Patient {

    String patid;
    String name;
    String age;
    String gender;
    String disease;




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

    @Override
    public String toString() {
        return "Patient [patid=" + patid + ", name =" + name + ", age=" +age+" gender = " +gender+"disease = " +disease+"]";
    }

}
