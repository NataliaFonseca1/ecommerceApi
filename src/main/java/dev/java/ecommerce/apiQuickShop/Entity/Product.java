package dev.java.ecommerce.apiQuickShop.Entity;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Product {
    @Id
    private Long id;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
