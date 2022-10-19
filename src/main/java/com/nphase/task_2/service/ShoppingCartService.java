package com.nphase.task_2.service;

import com.nphase.task_1.entity.ShoppingCart;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ShoppingCartService {

        public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(product -> {
                    boolean discountApplicable = product.getQuantity() > 3;
                    BigDecimal result = product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity()));
                    return discountApplicable ? result.subtract(result.multiply(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(100)))) : result;
                })
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
