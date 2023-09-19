package com.abhinav.abhinav_backend_starter.Services;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.ThirdPartyClients.FakeStoreProductDto;
import com.abhinav.abhinav_backend_starter.ThirdPartyClients.FakeStoreThirdPartyClient;
import com.abhinav.abhinav_backend_starter.Dtos.GenericProductDto;
import org.springframework.context.annotation.Primary;
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
    public List<GenericProductDto> getProducts() throws RequestFailedException {
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        fakeStoreThirdPartyClient.getProducts()
                .forEach(f -> genericProductDtos.add(convertToGenericProductDto(f)));
        return genericProductDtos;
    }
    public GenericProductDto getProductById(long id) throws NotFoundException {
        return convertToGenericProductDto(fakeStoreThirdPartyClient.getProductById(id));
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) throws RequestFailedException {
        return convertToGenericProductDto(fakeStoreThirdPartyClient.createProduct(genericProductDto));
    }
    @Override
    public GenericProductDto deleteProduct(GenericProductDto genericProductDto) {
        return null;
    }

    public GenericProductDto updateProduct(GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException {
        return convertToGenericProductDto(fakeStoreThirdPartyClient.updateProduct(genericProductDto));
    }
}
