package com.example.parul.myapplication;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserEdit {

    public String name;
    public String email;
    public String contact;
    public String econtact;
    public String gender;
    public String blood;
    public String allergy;
    public String past;
    public String problem;



    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public UserEdit() {
    }

    public UserEdit(String name, String email,String gender,String contact,String econtact,String blood,String allergy,String past) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.econtact = econtact;
        this.gender= gender;
        this.blood = blood;
        this.allergy = allergy;
        this.past = past;
        this.problem="";


    }
}


