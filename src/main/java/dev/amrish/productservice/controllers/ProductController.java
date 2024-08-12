package dev.amrish.productservice.controllers;

import dev.amrish.productservice.commons.AuthenticationCommons;
import dev.amrish.productservice.dto.CreateProductServiceDTO;
import dev.amrish.productservice.dto.ErrorDTO;
import dev.amrish.productservice.dto.UserDto;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.services.FakeStoreProductService;
import dev.amrish.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

   // ProductService productService = new FakeStoreProductService();

    private ProductService productService;
    private AuthenticationCommons authenticationCommons;

    public ProductController(@Qualifier("fakestoreservice") ProductService productService,
                             AuthenticationCommons authenticationCommons){
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }


    @PostMapping("/product")
    public Product createProduct(@RequestBody CreateProductServiceDTO createProductServiceDTO) {
        return productService.createProduct(
                createProductServiceDTO.getTitle(),
                createProductServiceDTO.getDescription(),
                createProductServiceDTO.getImageUrl(),
                createProductServiceDTO.getCategory(),
                createProductServiceDTO.getPrice()
        );
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
            return productService.getAllProduct();
    }
    //Jackson
    @GetMapping("/product/{id}")
    public Product getProductByIt(@PathVariable("id") Long id, @RequestHeader("Authorization") String token) throws IllegalAccessException {
        UserDto userDto = authenticationCommons.validateToken(token);
        if(userDto == null){
            throw new IllegalAccessException("Invalid Token");
        }
        return productService.getProductById(id);

    }

    @PutMapping("")
    public void updateProduct(){

    }

    public void deleteProduct(){

    }


//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorDTO> handlerNullPointerException(){
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setMsg("Something when wrong plz try after 15mim...!");
//
//        return new ResponseEntity<>(errorDTO, HttpStatusCode.valueOf(404));
//    }

}
