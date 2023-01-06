package com.example.customerDatabase.Customer;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name= "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private LocalDate dob;
    private String address;

    public Customer() {}

    public Customer(Long id, String name, String email, String phoneNum, LocalDate dob, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.address = address;
    }

    public Customer(String name, String email, String phoneNum, LocalDate dob, String address) {
        this.name = name;
        this.email = email;
        this.phoneNum = phoneNum;
        this.dob = dob;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                '}';
    }
}
