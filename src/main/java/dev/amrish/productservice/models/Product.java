package dev.amrish.productservice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends BaseModel {

    private String title;

    private String description;

    private String imageUrl;

    private double price;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private Category category;
}
