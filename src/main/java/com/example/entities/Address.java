package com.example.entities;

import javax.persistence.*;

@Embeddable//this annotation helps to add fileds of one clas tinsdie other class like fileds of ADDress are pushed inside Employee
public class Address {



    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }


    @Column(name="city_name")
    String city;
    @Column(name="Street_name")
    String Street;
    @Column(name="pin_code")
    int pincode;


}
