/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author dungc
 */
public class Address implements Serializable {
    private int id;
    private String street;
    private String city;
    private String country;
    private Customer cus;
    
    public Address(){
        super();
    }
    public Address(String street, String city, String country, Customer cus){
        super();
        this.street = street;
        this.city = city;
        this.country = country;
        this.cus = cus;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Customer getCus() {
        return cus;
    }

    public int getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
            
}
