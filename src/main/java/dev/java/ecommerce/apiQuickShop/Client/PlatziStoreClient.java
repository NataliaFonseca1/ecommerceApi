package dev.java.ecommerce.apiQuickShop.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="PlatziStoreClient", url ="${basket.client.platzi}")
public interface PlatziStoreClient {
    @GetMapping("/products")
    List<PlatziProductResponse> getAllProducts();


    @GetMapping("/products/{id}")
    PlatziProductResponse getProductById(@PathVariable Long id);
}
