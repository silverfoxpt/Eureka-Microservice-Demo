/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Eureka.Client;

/**
 *
 * @author ACCOUNT_NOSYSADMIN
 */

public class Recipe {
    private Integer id;
    private String recipeName;
    private Integer rating;

    public Recipe(Integer id, String recipeName, Integer rating) {
        this.id = id;
        this.recipeName = recipeName;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    
}
