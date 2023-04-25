/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.Eureka.Consumer.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
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
@RequestMapping("/order")
public class OrderResource {
    @GetMapping("/test")
    public ResponseEntity<Order> getTestOrders() {
        Map<String, String> uriVars = new HashMap<>();
        
        ResponseEntity<Recipe> resEntity = new RestTemplate().
            getForEntity("http://localhost:8082/recipe/test", Recipe.class, uriVars);
        
        if (resEntity.getBody() == null) {
            return ResponseEntity.badRequest().build();
        }
        
        Order testOrder = new Order();
        testOrder.setOrderNames(resEntity.getBody().getRecipeName());
        testOrder.setPriority(10);
        
        return ResponseEntity.ok(testOrder);
    }
}
