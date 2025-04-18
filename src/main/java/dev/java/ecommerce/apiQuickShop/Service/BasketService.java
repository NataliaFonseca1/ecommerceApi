package dev.java.ecommerce.apiQuickShop.Service;

import dev.java.ecommerce.apiQuickShop.Client.PlatziProductResponse;
import dev.java.ecommerce.apiQuickShop.Controller.Request.BasketRequest;
import dev.java.ecommerce.apiQuickShop.Controller.Request.PaymentRequest;
import dev.java.ecommerce.apiQuickShop.Entity.Basket;
import dev.java.ecommerce.apiQuickShop.Entity.Product;
import dev.java.ecommerce.apiQuickShop.Entity.Status;
import dev.java.ecommerce.apiQuickShop.Repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Optional<Basket> getBasketById(String id) {
        return basketRepository.findById(id);
    }

    public Basket createBasket(BasketRequest basketRequest) {
        basketRepository.findByClientAndStatus(basketRequest.getClientId(), Status.OPEN).ifPresent(basket -> {
            throw new IllegalArgumentException("Basket already exists");
        });

        List<Product> products = manageProductsRequest(basketRequest);

        Basket basket = Basket.builder()
                .client(basketRequest.getClientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket updateBasket(String basketId, BasketRequest basketRequest) {
        Basket basket = getBasket(basketId);

        List<Product> products = manageProductsRequest(basketRequest);

        basket.setProducts(products);
        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

    public Basket payBasket(String basketId, PaymentRequest paymentRequest) {
        Basket basket = getBasket(basketId);
        basket.setPaymentMethod(paymentRequest.getPaymentMethod());
        basket.setStatus(Status.SOLD);
        return basketRepository.save(basket);
    }

    public void deleteBasket(String basketId) {
        getBasket(basketId);
        basketRepository.deleteById(basketId);
    }

    private Basket getBasket(String basketId) {
        return this.getBasketById(basketId).orElseThrow(() -> new IllegalArgumentException("Basket not found"));
    }

    private List<Product> manageProductsRequest(BasketRequest basketRequest) {
        List<Product> products = new ArrayList<>();
        basketRequest.getProducts().forEach(productRequest -> {
            PlatziProductResponse platziProductReponse = productService.getProduct(productRequest.getId());
            products.add(Product.builder()
                    .id(platziProductReponse.id())
                    .price(platziProductReponse.price())
                    .title(platziProductReponse.title())
                    .quantity(productRequest.getQuantity())
                    .build());

        });
        return products;
    }
}
