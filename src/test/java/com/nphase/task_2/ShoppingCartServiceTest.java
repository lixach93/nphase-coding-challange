package com.nphase.task_2;


import com.nphase.task_1.entity.Product;
import com.nphase.task_1.entity.ShoppingCart;
import com.nphase.task_2.service.ShoppingCartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCartServiceTest {
    private final ShoppingCartService service = new ShoppingCartService();

        @Test
    public void calculatesPrice() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.0), 5),
                new Product("Coffee", BigDecimal.valueOf(3.5), 3)
        ));

        BigDecimal result = service.calculateTotalPrice(cart).setScale(1);

        Assertions.assertEquals(result, BigDecimal.valueOf(33.0));
    }

}