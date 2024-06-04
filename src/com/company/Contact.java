package com.company;

import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;  // Added serialVersionUID

    private String fullName;
    private String phone;
    private String address;
    private String email;
    private String birthDate;

    public Contact(String fullName, String phone, String address, String email, String birthDate) {
        this.fullName = fullName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "FullName: " + fullName + ", Phone: " + phone + ", Address: " + address +
                ", Email: " + email + ", BirthDate: " + birthDate;
    }
}
