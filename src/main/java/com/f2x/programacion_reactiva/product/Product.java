package com.f2x.programacion_reactiva.product;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("products")
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
}
