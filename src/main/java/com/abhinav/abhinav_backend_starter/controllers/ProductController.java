package com.abhinav.abhinav_backend_starter.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {


    @GetMapping()
//    http://localhost:8080/products
    public String getProducts() {return "All Products are returned"; }

    @GetMapping("/{id}")
//    http://localhost:8080/products/12345
    public String getProductById(@PathVariable("id") long id) {
        return "Product with id : " + id + " is returned";
    }

    @PostMapping
    public String createProduct() {
        return "Product with id : " + UUID.randomUUID() + " is created";
    }

    @PutMapping("/{id}")
    public String updateProductById(@PathVariable("id") long id) {
        return "Product with id : " + id +  "is updated";
    }

    @DeleteMapping ("/{id}")
    public String deleteProductById(@PathVariable("id") long id) {
        return "Product with id : " + id +  "is delelted";
    }
}
