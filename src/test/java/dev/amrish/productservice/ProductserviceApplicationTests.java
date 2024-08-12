package dev.amrish.productservice;

import dev.amrish.productservice.models.Category;
import dev.amrish.productservice.models.Product;
import dev.amrish.productservice.repository.CategoryRepository;
import dev.amrish.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductserviceApplicationTests {


//	@Autowired // -- Tells spring to inject the object of prod repo
//	ProductRepository productRepository;
//
//	@Autowired
//	CategoryRepository categoryRepository;
//
//	@Test
//	void contextLoads() {
//	}
//
//	@Test
//	void test1(){
//		Product product = productRepository.getProductWithASpecificTitleAndId("electronics", 1L);
//		System.out.println(product.getTitle());
//	}
//
//	    @Test
//    public void testingFetchTypes2() {
//        Category category = categoryRepository.findByTitle("electronics");
//        System.out.println(category.getTitle());
//    }
}
