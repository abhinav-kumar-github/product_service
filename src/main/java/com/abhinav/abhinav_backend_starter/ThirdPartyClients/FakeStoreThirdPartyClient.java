package com.abhinav.abhinav_backend_starter.ThirdPartyClients;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestNotSuccessfulException;
import com.abhinav.abhinav_backend_starter.constants.Constants;
import com.abhinav.abhinav_backend_starter.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class FakeStoreThirdPartyClient {
    private RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private String productRequestWithIdUrl ;
    private String productRequestUrl ;

    public void FakeStoreThirdPartyClient(RestTemplateBuilder restTemplateBuilder,
                                          String fakeStoreApiBaseUrl,
                                          String fakeStoreApiPathProduct) {
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestUrl = Constants.FAKE_STORE_API_BASE_URL + Constants.FAKE_STORE_API_PATH_PRODUCT;
        this.productRequestWithIdUrl = Constants.FAKE_STORE_API_BASE_URL + Constants.FAKE_STORE_API_PATH_PRODUCT + "/{id}";
    }

    public FakeStoreProductDto getProductById(long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productRequestWithIdUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id : " + id + "not found");
        }

        return fakeStoreProductDto;
    }
    public List<FakeStoreProductDto> getProducts() throws RequestNotSuccessfulException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestUrl, FakeStoreProductDto[].class);

        if(response.getBody() == null) {
            throw new RequestNotSuccessfulException("Products not found");
        }
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(response.getBody());
        return fakeStoreProductDtos;
    }
    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) throws RequestNotSuccessfulException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.postForEntity(productRequestUrl, genericProductDto, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;

        if(fakeStoreProductDto == null) {
            throw new RequestNotSuccessfulException("Product not created");
        }

        return fakeStoreProductDto;
    }
    public FakeStoreProductDto deleteProductById(long id) throws RequestNotSuccessfulException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor
                = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response
                = restTemplate.execute(productRequestWithIdUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        FakeStoreProductDto fakeStoreProductDto = response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;

        if(fakeStoreProductDto == null) {
            throw new RequestNotSuccessfulException("Product not deleted");
        }

        return fakeStoreProductDto;
    }
    public FakeStoreProductDto updateProduct(GenericProductDto genericProductDto) {
        return null;
    }
}