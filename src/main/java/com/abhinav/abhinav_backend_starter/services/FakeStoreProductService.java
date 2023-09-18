package com.abhinav.abhinav_backend_starter.services;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.ThirdPartyClients.FakeStoreProductDto;
import com.abhinav.abhinav_backend_starter.ThirdPartyClients.FakeStoreThirdPartyClient;
import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeStoreProductService implements ProductService{
    FakeStoreThirdPartyClient fakeStoreThirdPartyClient;

    public FakeStoreProductService(FakeStoreThirdPartyClient fakeStoreThirdPartyClient) {
        this.fakeStoreThirdPartyClient = fakeStoreThirdPartyClient;
    }
    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        return GenericProductDto.builder()
                .id(fakeStoreProductDto.getId())
                .title(fakeStoreProductDto.getTitle())
                .price(fakeStoreProductDto.getPrice())
                .description(fakeStoreProductDto.getDescription())
                .category(fakeStoreProductDto.getCategory())
                .image(fakeStoreProductDto.getImage())
                .build();
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }
    @Override
    public GenericProductDto deleteProductById(long id) {
        return null;
    }
    public GenericProductDto getProductById(long id) throws NotFoundException {
        return convertToGenericProductDto(fakeStoreThirdPartyClient.getProductById(id));
    }
    public GenericProductDto updateProduct(GenericProductDto genericProductDto) {
        return null;
    }
    @Override
    public List<GenericProductDto> getProducts() throws RequestFailedException {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreThirdPartyClient.getProducts();
        System.out.println(fakeStoreProductDtos.size() + " products found abhinav");
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        fakeStoreProductDtos.forEach(fakeStoreProductDto -> {
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        });

        return genericProductDtos;
    }
}
