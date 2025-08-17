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
public class Order implements Serializable{
    private Book book;
    private int quantity;
    private int rentalPrice;
    
    public Order(){
        super();
    }
    public Order(Book book, int quantity, int rentalPrice){
        super();
        this.book = book;
        this.quantity = quantity;
        this.rentalPrice = rentalPrice;
    }

    public Book getBook() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    
            
}
