package com.example.parul.myapplication;


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserHelp {

    public String name;
    public String contact;
    public String problem;
    public String address;
    public Integer emer;
    public Integer respond;


    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public UserHelp() {
    }

    public UserHelp(String name, String contact,String problem,String address) {
        this.name = name;
        this.contact = contact;
        this.problem=problem;
        this.address=address;
        this.emer=0;
        this.respond=0;



    }
}
