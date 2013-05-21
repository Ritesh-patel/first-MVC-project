/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ritz
 */
package com.lab1.controller;

/**
 *
 * @author Ritz
 */
public class book 
{
    private int book_id;
    private long isbn;
    private String title;
    private String author;
    private String publisher;
    private int price;
    private String image_name;
    private int qty;
    private int order;

    public int getBook_id() {
        return book_id;
    }

    public int getOrder() {
        return order;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPrice() {
        return price;
    }

    public String getImage_name() {
        return image_name;
    }

    public int getQty() {
        return qty;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

   
}
