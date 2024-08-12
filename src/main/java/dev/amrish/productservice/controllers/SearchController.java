package dev.amrish.productservice.controllers;

import dev.amrish.productservice.dto.SearchrequestDTO;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public Page<Product> search(@RequestBody SearchrequestDTO searchrequestDTO){

        return searchService.search(
                searchrequestDTO.getQuery(),
                searchrequestDTO.getPageNo(),
                searchrequestDTO.getPageSize()
        );
    }
}
