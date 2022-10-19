package com.nphase.task_4;


import com.nphase.task_3.entity.Category;
import com.nphase.task_3.entity.Product;
import com.nphase.task_3.entity.ShoppingCart;
import com.nphase.task_4.services.ShoppingCartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShoppingCartServiceTest {
    private final ShoppingCartService service = new ShoppingCartService();

    @Test
    public void calculatesPrice() {
        ShoppingCart cart = new ShoppingCart(Arrays.asList(
                new Product("Tea", BigDecimal.valueOf(5.3), 2, Category.DRINK),
                new Product("Coffee", BigDecimal.valueOf(3.5), 2,Category.DRINK),
                new Product("Cheese", BigDecimal.valueOf(8), 2,Category.FOOD)

        ));

        BigDecimal result = service.calculateTotalPrice(cart);

        Assertions.assertEquals(result, BigDecimal.valueOf(31.84));
    }

}