package dev.java.ecommerce.apiQuickShop.Controller.Request;

import dev.java.ecommerce.apiQuickShop.Entity.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    private PaymentMethod paymentMethod;
}
