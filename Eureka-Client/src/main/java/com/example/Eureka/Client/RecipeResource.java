/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Eureka.Client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ACCOUNT_NOSYSADMIN
 */

@RestController
@RequestMapping("/recipe")
public class RecipeResource {
    @Value("${server.port}")
    private Integer serverPort;
    
    @GetMapping("/test")
    public Recipe getTestRecipe() {
        return new Recipe(1, "Cookies", 5);
    }
    
    @GetMapping("/port")
    public ResponseEntity<String> getPort() {
        return ResponseEntity.ok(serverPort.toString());
    }
}

