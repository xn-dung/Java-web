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
public class Book implements Serializable {
    private int id;
    private String title;
    private int yearOfPublication;
    private String author;
    private int rentalPrice;
    private int number;
    
    public Book(){
        super();
    }
    public Book(String title, int yearOfPublication, String author, int rentalPrice, int number){
        super();
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        this.rentalPrice = rentalPrice;
        this.number = number;
        
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
            
}
