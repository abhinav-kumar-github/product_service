package com.abhinav.abhinav_backend_starter.ThirdPartyClients;

import com.abhinav.abhinav_backend_starter.Exceptions.NotFoundException;
import com.abhinav.abhinav_backend_starter.Exceptions.RequestFailedException;
import com.abhinav.abhinav_backend_starter.Constants.Constants;
import com.abhinav.abhinav_backend_starter.Dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreThirdPartyClient {
    private static RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    private static String productRequestWithIdUrl
            = Constants.FAKE_STORE_API_BASE_URL + Constants.FAKE_STORE_API_PATH_PRODUCT + "/{id}";
    private static String productRequestUrl
            = Constants.FAKE_STORE_API_BASE_URL + Constants.FAKE_STORE_API_PATH_PRODUCT;

    public FakeStoreProductDto getProductById(long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(productRequestWithIdUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;

        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id " + id + " not found");
        }

        return fakeStoreProductDto;
    }
    public List<FakeStoreProductDto> getProducts() throws RequestFailedException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response =
                restTemplate.getForEntity(productRequestUrl, FakeStoreProductDto[].class);

        if(response.getBody() == null) {
            throw new RequestFailedException("Products not found");
        }
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(response.getBody());
        return fakeStoreProductDtos;
    }
    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) throws RequestFailedException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.postForEntity(productRequestUrl, genericProductDto, FakeStoreProductDto.class);

        FakeStoreProductDto fakeStoreProductDto = response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;

        if(fakeStoreProductDto == null) {
            throw new RequestFailedException("Product not created");
        }

        return fakeStoreProductDto;
    }
    public FakeStoreProductDto deleteProduct(GenericProductDto genericProductDto) throws RequestFailedException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor
                = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(productRequestWithIdUrl, HttpMethod.DELETE, requestCallback,
                        responseExtractor, genericProductDto.getId());

        FakeStoreProductDto fakeStoreProductDto = response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;

        if(fakeStoreProductDto == null) {
            throw new RequestFailedException("Product not deleted");
        }

        return fakeStoreProductDto;
    }
    public FakeStoreProductDto updateProduct(GenericProductDto genericProductDto) throws NotFoundException, RequestFailedException {
        FakeStoreProductDto fakeStoreProductDto = getProductById(genericProductDto.getId());
        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id " + genericProductDto.getId() + " not found for deletion");
        }

        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = productRequestWithIdUrl;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor
                = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, genericProductDto.getId());

        if(!response.getStatusCode().is2xxSuccessful()) {
            throw new RequestFailedException("Product not updated");
        }
        return fakeStoreProductDto;
    }

}
