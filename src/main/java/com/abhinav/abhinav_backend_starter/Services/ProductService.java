package com.abhinav.abhinav_backend_starter.Services;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.Dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    List<GenericProductDto> getProducts() throws RequestFailedException;
    GenericProductDto getProductById(long id) throws NotFoundException;
    GenericProductDto createProduct(GenericProductDto genericProductDto) throws RequestFailedException;
    GenericProductDto updateProduct(GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException;
    GenericProductDto deleteProduct(GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException;
}
