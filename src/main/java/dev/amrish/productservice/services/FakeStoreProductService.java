package dev.amrish.productservice.services;


import dev.amrish.productservice.dto.FakeStoreProductDTO;
import dev.amrish.productservice.models.Category;
import dev.amrish.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakestoreservice")
public class FakeStoreProductService  implements ProductService{

    private  RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }



    @Override
    public Product getProductById(Long id) {



           FakeStoreProductDTO fakeStoreProductDTO = restTemplate
                    .getForObject("https://fakestoreapi.com/products/" + id,
                            FakeStoreProductDTO.class);

           return convertToProdcut(fakeStoreProductDTO);
    }

    @Override
    public Product createProduct(String title, String description, String image, String category, double price) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setImageUrl(image);
        fakeStoreProductDTO.setCategory(category);
        fakeStoreProductDTO.setPrice(price);

         FakeStoreProductDTO response = restTemplate.postForObject(
                "https://fakestoreapi.com/products", fakeStoreProductDTO,
                FakeStoreProductDTO.class
        );
        return convertToProdcut(response);
    }

    @Override
    public List<Product> getAllProduct() {

        FakeStoreProductDTO[] response = restTemplate.getForObject("https://fakestoreapi.com/products",
               FakeStoreProductDTO[].class);

        List<Product>  products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : response){
            products.add(convertToProdcut(fakeStoreProductDTO));
        }

        return products;
    }


    public Product convertToProdcut(FakeStoreProductDTO fakeStoreProductDTO){

        Product product = new Product();

        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImageUrl(fakeStoreProductDTO.getImageUrl());
       // product.setId(fakeStoreProductDTO.getId());

        Category category = new Category();
        category.setTitle(fakeStoreProductDTO.getCategory());
        product.setCategory(category);


        return product;

    }
}
