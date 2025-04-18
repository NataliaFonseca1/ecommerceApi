package dev.java.ecommerce.apiQuickShop.Service;

import dev.java.ecommerce.apiQuickShop.Client.PlatziProductResponse;
import dev.java.ecommerce.apiQuickShop.Client.PlatziStoreClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);
    private final PlatziStoreClient platziStoreClient;

    public ProductService(PlatziStoreClient platziStoreClient) {
        log.info("Getting all producsts");
        this.platziStoreClient = platziStoreClient;
    }

    @Cacheable(value="products")
    public List<PlatziProductResponse> getAllProducts(){
        log.info("Getting product with id: {}");
    return platziStoreClient.getAllProducts();
}
@Cacheable(value = "products", key ="#productId")
public PlatziProductResponse getProduct(Long productId){
    return platziStoreClient.getProductById(productId);
}

}
