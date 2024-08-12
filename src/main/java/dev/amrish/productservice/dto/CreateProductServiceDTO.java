package dev.amrish.productservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductServiceDTO {
    private String title;

    private String description;

    private String imageUrl;

    private double price;

    private String category;
}
