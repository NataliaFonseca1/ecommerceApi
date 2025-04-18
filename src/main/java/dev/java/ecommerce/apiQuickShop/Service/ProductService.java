package dev.java.ecommerce.apiQuickShop.Service;

import dev.java.ecommerce.apiQuickShop.Client.PlatziProductResponse;
import dev.java.ecommerce.apiQuickShop.Client.PlatziStoreClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    public ProductService(PlatziStoreClient platziStoreClient) {
        this.platziStoreClient = platziStoreClient;
    }


    public List<PlatziProductResponse> getAllProducts(){
    return platziStoreClient.getAllProducts();
}

public PlatziProductResponse getProductById(Long id){
    return platziStoreClient.getProductById(id);
}


}
