package com.nphase.task_1.service;

import com.nphase.task_1.entity.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartService {

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getProducts()
                .stream()
                .map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
