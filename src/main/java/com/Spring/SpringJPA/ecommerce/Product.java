package com.Spring.SpringJPA.ecommerce;

import javax.persistence.Entity;

@Entity
public class Product {

    private long Id;
    private String name;
    private String description;
    private Double price;
    private Product Category;


}
