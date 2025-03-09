package com.f2x.programacion_reactiva.product;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/price/{price}")
    public Flux<Product> getProductsByPrice(@PathVariable BigDecimal price) {
        return productService.getProductsByPrice(price);
    }

    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
