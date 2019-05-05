package com.example.parul.myapplication;

public class UserInformation {
    public String hospitalname;
    public double latitude;
    public double longitude;

    public UserInformation(){

    }
    public UserInformation(String hospitalname,double latitude,double longitude){
        this.hospitalname=hospitalname;
        this.latitude=latitude;
        this.longitude=longitude;
    }
}
