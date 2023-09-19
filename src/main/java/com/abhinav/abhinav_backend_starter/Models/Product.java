package com.abhinav.abhinav_backend_starter.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
