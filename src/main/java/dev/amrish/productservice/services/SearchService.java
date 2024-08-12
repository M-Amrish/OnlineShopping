package dev.amrish.productservice.services;

import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Page<Product> search(String query, int pageNumber, int pageSize){

        Sort sort = Sort.by("title").descending();
        Pageable pagable = PageRequest.of(pageNumber, pageSize, sort);

       return  productRepository.findByTitleContaining(query, pagable);


    }
}
