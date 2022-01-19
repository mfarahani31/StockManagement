package com.hoom.stockmanagement.service;

import com.hoom.stockmanagement.MotherObject;
import com.hoom.stockmanagement.model.Product;
import com.hoom.stockmanagement.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        product = MotherObject.getAnyProduct();
    }

    @Test
    void testContext() {
        assertNotNull(productService);
        assertNotNull(productRepository);
    }

    @Test
    void save() {
        productService.save(this.product);

        verify(productRepository, times(1)).save(this.product);
    }

    @Test
    void buy() {
        Product productTwo = new Product(1L, "cellphone", "black", "Test description", product.getStock() - 10L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(this.product));
        when(productRepository.save(productTwo)).thenReturn(productTwo);

        productService.buy(1L, 10L);

        assertEquals(1L, productTwo.getId());
        assertEquals(productTwo.getStock(), productTwo.getStock());

    }

    @Test
    void buy_throws_server_exception_when_count_greater_than_stock() {

        when(productRepository.findById(1L)).thenReturn(Optional.of(this.product));

        //productService.buy(1L,1000L);

        assertThrows(HttpServerErrorException.class, () -> productService.buy(1L, 1000L));

    }

    @Test
    void findById_throws_exception() {
        when(productRepository.findById(1L)).thenThrow(new HttpServerErrorException(HttpStatus.NOT_FOUND));
        assertThrows(HttpServerErrorException.class, () -> productService.findById(1L));
    }

    @Test
    void findById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(this.product));

        Product product = productService.findById(1L);

        assertEquals("cellphone", product.getName());
        assertEquals("Test description", product.getDescription());
        assertEquals("black", product.getColor());
        assertEquals(50L, product.getStock());
    }

    @Test
    void findAll() {
        List<Product> list = new ArrayList<>();
        Product productTwo = new Product(2L, "coat", "black", "Test description", 50L);
        Product productThree = new Product(3L, "shirt", "black", "Test description", 50L);

        list.add(this.product);
        list.add(productTwo);
        list.add(productThree);

        when(productRepository.findAll()).thenReturn(list);

        //test
        List<Product> productList = productService.findAll();

        assertEquals(3, productList.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void update() {
        Product productTwo = new Product(2L, "cellphone", "gold", "Test description", 50L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(this.product));
        when(productRepository.save(productTwo)).thenReturn(productTwo);

        Product product = productService.update(productTwo, 1L);

        assertEquals(1L, product.getId());
        assertEquals(productTwo.getName(), product.getName());
        assertEquals(productTwo.getDescription(), product.getDescription());
        assertEquals(productTwo.getColor(), product.getColor());
        assertEquals(productTwo.getStock(), product.getStock());
    }


    @Test
    void getStockOfProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(this.product));

        Long productStock = productService.getStockOfProduct(1L);

        assertEquals(50L, productStock);
    }

    @Test
    void refill() {
        Product productTwo = new Product(1L, "cellphone", "black", "Test description", 50L + 40L);

        when(productRepository.findById(1L)).thenReturn(Optional.of(this.product));
        when(productRepository.save(productTwo)).thenReturn(productTwo);

        productService.refill(1L, 40L);

        assertEquals(1L, productTwo.getId());
        assertEquals(90L, this.product.getStock());
    }
}