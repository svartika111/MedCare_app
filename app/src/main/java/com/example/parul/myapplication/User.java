package com.example.parul.myapplication;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {

    public String name;
    public String email;
    public String contact;
    public String econtact;
    public String gender;
    public String blood;
    public String allergy;
    public String past;
    public String problem;
    public String hospitalRef;
    public Integer emer;
    public Integer respond;
    public Integer age;
    public double latitude;
    public double longitude;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public User() {
    }

    public User(String name, String email,Integer age,String gender,String contact,String econtact,String blood,String allergy,String past,double latitude,double longitude) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.econtact = econtact;
        this.gender= gender;
        this.blood = blood;
        this.allergy = allergy;
        this.past = past;
        this.age=age;
        this.problem="";
        this.emer=0;
        this.respond=0;
        this.latitude=0.000;
        this.longitude=0.000;
        this.hospitalRef="";

    }
}
