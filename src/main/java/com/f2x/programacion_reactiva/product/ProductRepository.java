package com.f2x.programacion_reactiva.product;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Flux<Product> findByNameContainingIgnoreCase(String name);
}