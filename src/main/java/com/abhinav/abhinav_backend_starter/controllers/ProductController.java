package com.abhinav.abhinav_backend_starter.controllers;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;
import com.abhinav.abhinav_backend_starter.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
//    http://localhost:8080/products
//    {
//        "title": "test product",
//            "price": 13.5,
//            "description": "lorem ipsum set",
//            "image": "https://i.pravatar.cc",
//            "category": "electronic"
//    }
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto genericProductDto)
            throws RequestFailedException {
        return new ResponseEntity(productService.createProduct(genericProductDto), HttpStatus.OK);
    }

    @PutMapping
//    {
//        "id": 1,
//            "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
//            "description": "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
//            "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
//            "category": "men's clothing",
//            "price": 109.95
//    }
    public ResponseEntity<GenericProductDto> updateProduct(@RequestBody GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException {
        return new ResponseEntity(productService.updateProduct(genericProductDto), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") long id) {
        return new ResponseEntity(productService.deleteProductById(id), HttpStatus.OK);
    }
}
