/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author dungc
 */
public class OrderList implements Serializable {
    private int id;
    private ArrayList<Order> list;
    private Customer cus;
    private String date;
    private Address address;
    
    public OrderList(){
        super();
    }
    public OrderList(ArrayList<Order> list, Customer cus, String date, Address address){
        super();
        this.cus = cus;
        this.list = list;
        this.date = date;
        this.address = address;
    }

    public Customer getCus() {
        return cus;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Order> getList() {
        return list;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(ArrayList<Order> list) {
        this.list = list;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
    
    
    
}
