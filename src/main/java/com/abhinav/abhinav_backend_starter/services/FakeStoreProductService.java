package com.abhinav.abhinav_backend_starter.services;

import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;
import lombok.Builder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements ProductService{
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }
    @Override
    public GenericProductDto deleteProductById(long id) {
        return null;
    }
    public GenericProductDto getProductById(long id) {
        return null;
    }
    public GenericProductDto updateProduct(GenericProductDto genericProductDto) {
        return null;
    }
    @Override
    public List<GenericProductDto> getProducts() {
        return null;
    }
}
