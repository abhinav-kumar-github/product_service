package com.abhinav.abhinav_backend_starter.Dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GenericProductDto {
    private long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;
}
