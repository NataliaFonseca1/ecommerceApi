package dev.java.ecommerce.apiQuickShop.Controller;

import dev.java.ecommerce.apiQuickShop.Client.PlatziProductResponse;
import dev.java.ecommerce.apiQuickShop.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

private  ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
public ResponseEntity<List<PlatziProductResponse>> getAllProducts(){
    return ResponseEntity.ok(productService.getAllProducts());
}

@GetMapping("/{id}")
    public ResponseEntity<PlatziProductResponse> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
}


}
