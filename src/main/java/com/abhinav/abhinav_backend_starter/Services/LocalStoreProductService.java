package com.abhinav.abhinav_backend_starter.Services;

import com.abhinav.abhinav_backend_starter.Dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LocalStoreProductService implements ProductService{
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }
    @Override
    public GenericProductDto deleteProduct(GenericProductDto genericProductDto) { return null;}
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
