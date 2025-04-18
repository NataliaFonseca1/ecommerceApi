package dev.java.ecommerce.apiQuickShop.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Builder
@Data
public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private Long quantity;

}
