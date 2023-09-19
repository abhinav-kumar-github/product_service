package com.abhinav.abhinav_backend_starter.Controllers;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.Dtos.GenericProductDto;
import com.abhinav.abhinav_backend_starter.Services.ProductService;
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
    public ResponseEntity<List<GenericProductDto>> getProducts() throws RequestFailedException {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDto> getProductById(@PathVariable("id") long id) throws NotFoundException {
        return new ResponseEntity(productService.getProductById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto genericProductDto)
            throws RequestFailedException {
        return new ResponseEntity(productService.createProduct(genericProductDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<GenericProductDto> updateProduct(@RequestBody GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException {
        return new ResponseEntity(productService.updateProduct(genericProductDto), HttpStatus.OK);
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<GenericProductDto> deleteProduct(@RequestBody GenericProductDto genericProductDto)
            throws RequestFailedException, NotFoundException {
        return new ResponseEntity(productService.deleteProduct(genericProductDto), HttpStatus.OK);
    }
}
