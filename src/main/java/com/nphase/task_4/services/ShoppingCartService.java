package com.nphase.task_4.services;

import com.nphase.common.Constants;
import com.nphase.task_3.entity.Category;
import com.nphase.task_3.entity.Product;
import com.nphase.task_3.entity.ShoppingCart;
import com.nphase.task_4.properties.PropertyLoader;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingCartService {

    public BigDecimal calculateTotalPrice(ShoppingCart shoppingCart) {

        Map<Category, List<Product>> products = shoppingCart.getProducts()
                .stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        return products.values().stream()
                .map(this::calculateCategory)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private BigDecimal calculateCategory(List<Product> products) {
        int quantity = 0;
        boolean discountApplicable = false;
        for (Product product : products) {
            quantity += product.getQuantity();
            if (quantity > Integer.parseInt(PropertyLoader.getProperty(Constants.ITEM))) {
                discountApplicable = true;
                break;
            }
        }
        BigDecimal result = products.stream()
                .map(product -> product.getPricePerUnit().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
        return discountApplicable ? result.subtract(result.multiply(new BigDecimal(PropertyLoader.getProperty(Constants.DISCOUNT))
                .divide(BigDecimal.valueOf(100)))) : result;

    }
}
