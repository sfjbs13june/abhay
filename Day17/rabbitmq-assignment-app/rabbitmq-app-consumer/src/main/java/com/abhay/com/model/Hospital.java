package com.abhay.com.model;

import org.springframework.stereotype.Component;

@Component
public class Hospital {

    String hosId;
    String name;
    String city;

    public Hospital(){

    }

    public Hospital(String hosId, String name, String city) {
        this.hosId = hosId;
        this.name = name;
        this.city = city;
    }

    public String getHosId() {
        return hosId;
    }

    public void setHosId(String hosId) {
        this.hosId = hosId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
