package com.f2x.programacion_reactiva.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Flux<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Mono<Void> deleteProduct(Long id) {
        return productRepository.deleteById(id);
    }

    public Flux<Product> getProductsByPrice(BigDecimal price) {
        return productRepository.findAll()
                .filter(product -> product.getPrice().compareTo(price) < BigDecimal.ZERO.intValue())
                .switchIfEmpty(Flux.error(new NoSuchElementException("No products found under " + price)));
    }

}
