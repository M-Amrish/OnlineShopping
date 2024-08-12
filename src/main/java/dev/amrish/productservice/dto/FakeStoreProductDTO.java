package dev.amrish.productservice.dto;

import dev.amrish.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;

    private String title;

    private String description;

    private String imageUrl;

    private double price;

    private String category;
}
