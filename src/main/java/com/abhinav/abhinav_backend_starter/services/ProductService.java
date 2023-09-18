package com.abhinav.abhinav_backend_starter.services;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    List<GenericProductDto> getProducts() throws RequestFailedException;
    GenericProductDto getProductById(long id) throws NotFoundException;
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    GenericProductDto updateProduct(GenericProductDto genericProductDto);
    GenericProductDto deleteProductById(long id);
}
