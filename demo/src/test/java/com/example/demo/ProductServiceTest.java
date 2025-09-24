package com.example.demo;

import com.eafit.tutorial.model.Product;
import com.eafit.tutorial.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.eafit.tutorial.service.impl.ProductServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository repository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    void shouldCreateProductSuccessfully() {
        // Given
        Product product = createValidProduct();
        when(repository.save(any())).thenReturn(product);

        // When
        Product result = productService.createProduct(product);

        // Then
        assertThat(result.getName()).isEqualTo("Test Product");
        verify(repository).save(product);
    }

    private Product createValidProduct() {
        Product p = new Product();
        p.setId(1L);
        p.setName("Test Product");
        p.setPrice(java.math.BigDecimal.valueOf(100.00000));
        p.setCategory("Electrónicos");
        p.setActive(true);
        return p;
    }
}
