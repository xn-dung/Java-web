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
public class Account implements Serializable {
    private int id;
    private String username;
    private String password;
    private Customer cus;
    
    public Account(){
        super();
    }
    public Account(String username, String password, Customer cus){
        super();
        this.username = username;
        this.password = password;
        this.cus = cus;
    }

    public int getId() {
        return id;
    }

    public Customer getCus() {
        return cus;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setCus(Customer cus) {
        this.cus = cus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
