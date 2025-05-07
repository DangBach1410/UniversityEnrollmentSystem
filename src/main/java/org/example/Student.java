package org.example;

import java.util.Date;

public class Student {
    private String id;
    private String fullname;
    private String address;
    private String phone;
    private String email;
    private boolean sex;
    private Date DoB;
    private float grade;

    public Student(String id,
                   String fullname,
                   String address,
                   String phone,
                   String email,
                   boolean sex,
                   Date doB,
                   float grade) {
        this.address = address;
        this.DoB = doB;
        this.email = email;
        this.fullname = fullname;
        this.grade = grade;
        this.id = id;
        this.phone = phone;
        this.sex = sex;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getID(){
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
