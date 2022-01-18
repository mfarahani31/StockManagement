package com.hoom.stockmanagement.controller;

import com.hoom.stockmanagement.model.Product;
import com.hoom.stockmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getOneById(@PathVariable Long productId) {
        return ResponseEntity.ok(this.productService.findById(productId));
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.save(product));
    }

    @GetMapping("/getStock/{productId}")
    public ResponseEntity<Long> getStock(@PathVariable Long productId) {
        return ResponseEntity.ok(this.productService.getStockOfProduct(productId));
    }

    @PatchMapping("/refill/{productId}")
    public ResponseEntity<Product> refillProduct(@PathVariable Long productId, @RequestBody Long count) {
        return ResponseEntity.status(HttpStatus.OK).body(this.productService.refill(productId, count));
    }

    @PostMapping("/{productId}")
    public void buyProduct(@PathVariable Long productId, @RequestBody Long count) {
        this.productService.buy(productId, count);
    }


}
