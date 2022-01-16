package com.hoom.stockmanagement.service;

import com.hoom.stockmanagement.model.Product;
import com.hoom.stockmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Product save(Product product) {

        return this.productRepository.save(product);
    }

    public void buy(Long productId, Long count) {
        Product product = this.findById(productId);
        if (product.getStock() < count)
            throw new HttpServerErrorException(HttpStatus.UNPROCESSABLE_ENTITY);
        product.setStock(product.getStock() - count);
        this.update(product, productId);
    }


    public Product findById(Long id) {
        return this.productRepository.findById(id).orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND));
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    Product update(Product newProduct, Long id) {
        this.findById(id);
        newProduct.setId(id);
        return this.save(newProduct);
    }

    public void deleteById(Long productId) {
        this.productRepository.deleteById(productId);
    }

    public Long getStockOfProduct(Long productId) {
        return this.productRepository.findById(productId).get().getStock();
    }

    public void refill(Long productId, Long count) {
        Product product = this.findById(productId);
        product.setStock(product.getStock() + count);
        this.update(product, productId);
    }
}
