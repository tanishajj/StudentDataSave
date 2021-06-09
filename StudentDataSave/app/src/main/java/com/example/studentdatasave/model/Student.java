package com.example.studentdatasave.model;

import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class Student {
    public String id;
    public String name;
    public String surname;
    public String email;
    public String password;
    public String confirm_password;
    public String country;
    public String state;
    public String city;
    public String pin_code;
    public String phone_no;
    public byte[] data;

    public Student(String sid, String sfname, String slast, String semail, String spaswword, String sfinalp, String scountry, String sstate, String scity, String spincode, String sphone, byte[] data){
        this.id=sid;
        this.name=sfname;
        this.surname=slast;
        this.email=semail;
        this.password=spaswword;
        this.confirm_password=sfinalp;
        this.pin_code=spincode;
        this.phone_no=sphone;
        this.country=scountry;
        this.state=sstate;
        this.city=scity;

        this.data=data;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getPin_code() {
        return pin_code;
    }

    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }
    public byte[] getImage() {
        return data;
    }

    public void setImage(byte[] image) {
        this.data = image;
    }

}
