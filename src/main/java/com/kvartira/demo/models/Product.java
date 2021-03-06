package com.kvartira.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy  = GenerationType.AUTO)
    private Long id;

    private String name;

    private int price;





    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Product(String name, int price){
        this.name = name;
        this.price = price;

    }

    public Product(){

    }

}
