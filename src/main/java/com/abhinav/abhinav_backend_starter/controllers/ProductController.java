package com.abhinav.abhinav_backend_starter.controllers;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.dtos.ExceptionDto;
import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;
import com.abhinav.abhinav_backend_starter.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
//    http://localhost:8080/products
    public ResponseEntity<List<GenericProductDto>> getProducts() throws RequestFailedException {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
//    http://localhost:8080/products/12345
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") long id) throws NotFoundException {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericProductDto> createProduct() {
        GenericProductDto genericProductDto = GenericProductDto.builder().build();
        return new ResponseEntity<>(productService.createProduct(genericProductDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto> updateProduct(@PathVariable("id") long id) {
        GenericProductDto genericProductDto = GenericProductDto.builder().build();
        return new ResponseEntity<>(productService.updateProduct(genericProductDto), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") long id) {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }
}
