package com.abhinav.abhinav_backend_starter.ThirdPartyClients;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.ThirdPartyClients.FakeStore.FakeStoreProductDto;
import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;

import java.util.List;

public interface ThirdPartyClient {
    List<FakeStoreProductDto> getProducts() throws RequestFailedException;
    FakeStoreProductDto getProductById(long id) throws NotFoundException;
    FakeStoreProductDto createProduct(GenericProductDto genericProductDto) throws RequestFailedException;
    FakeStoreProductDto updateProduct(GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException;
    FakeStoreProductDto deleteProduct(GenericProductDto genericProductDto) throws RequestFailedException, NotFoundException;
}
