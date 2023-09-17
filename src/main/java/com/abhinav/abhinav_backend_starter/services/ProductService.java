package com.abhinav.abhinav_backend_starter.services;

import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    List<GenericProductDto> getProducts();
    GenericProductDto getProductById(long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProduct(GenericProductDto genericProductDto);
    GenericProductDto deleteProductById(long id);
}
