package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductById() {
        Product mockProduct = new Product();
        mockProduct.setId(1L);
        mockProduct.setName("Test Product");
        mockProduct.setPrice(10.0);

        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));

        Optional<Product> retrievedProduct = productService.getProductById(1L);
        assertEquals("Test Product", retrievedProduct.get().getName());
    }

    // Write similar tests for other methods
}
