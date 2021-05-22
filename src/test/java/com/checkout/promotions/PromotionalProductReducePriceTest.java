package com.checkout.promotions;

import com.checkout.model.Product;
import com.checkout.services.Cart;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromotionalProductReducePriceTest {

    @DisplayName("Add promotional discount to Cart and return discounted value")
    @Test
    public void addProductsToCartAndReturnPromotionalDiscountValue() {
        double expectedDiscountValue = 2.50;
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);
        Cart cart = new Cart();
        cart.addProduct(item1);
        cart.addProduct(item2);
        cart.addProduct(item1);

        PromotionalProductReducePrice promotions = new PromotionalProductReducePrice(item1, 2, 8.00);

        double output = promotions.calculateDiscount(cart.getItems());
        assertEquals(expectedDiscountValue, output);
    }

    @DisplayName("No promotional discount applied to Cart so return value as zero")
    @Test
    public void addProductsToCartAndReturnZeroDiscountValue() {
        double expectedDiscountValue = 0.00;
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);
        Cart cart = new Cart();
        cart.addProduct(item1);
        cart.addProduct(item2);
        cart.addProduct(item3);

        PromotionalProductReducePrice promotions = new PromotionalProductReducePrice(item1, 2, 8.00);

        double output = promotions.calculateDiscount(cart.getItems());
        assertEquals(expectedDiscountValue, output);
    }
}