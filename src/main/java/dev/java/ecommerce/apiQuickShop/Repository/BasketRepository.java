package dev.java.ecommerce.apiQuickShop.Repository;


import dev.java.ecommerce.apiQuickShop.Entity.Basket;
import dev.java.ecommerce.apiQuickShop.Entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {

    Optional<Basket> findByClientAndStatus(Long client, Status status);
}