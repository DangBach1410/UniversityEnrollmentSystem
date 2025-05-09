package org.example.models;

import java.util.Date;

public class Person {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private boolean sex;
    private Date birthDay;

    public Person(String fullName, String email, String password, String phone, boolean sex, Date birthDay) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
