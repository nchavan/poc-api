package com.checkout.services;

import com.checkout.exception.InvalidInput;
import com.checkout.model.Product;
import com.checkout.promotions.PromotionalRules;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutTest {

    @DisplayName("Cart with no product and some promotions then return zero total")
    @Test
    public void whenCartWithNoItemsThenReturnTotal() {
        String expectedPrice = "£0.00";
        Product item1 = new Product("001", "Travel Card Holder", 9.25);

        PromotionalRules promotionalRules = new PromotionalRules();
        promotionalRules.buyMultipleSameProductsAndReduceProductPrice(item1,2, 8.50);
        promotionalRules.applyTotalDiscountOnCart(60, 10);

        Checkout co = new Checkout(promotionalRules);
        String price = co.total();
        assertEquals(price, expectedPrice);
    }

    @DisplayName("Cart with one product and null promotions then return zero total")
    @Test
    public void whenCartWithNullPromotionsThenReturnTotal() throws InvalidInput {
        String expectedPrice = "£29.20";
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);

        Checkout co = new Checkout(null);
        co.scan(item1);
        co.scan(item3);

        String price = co.total();
        assertEquals(price, expectedPrice);
    }

    @DisplayName("Cart with null product and null promotions then receive Invalid Input Exception")
    @Test
    public void whenCartWithNullPromotionsAndNullProductsThenReturnTotal() {
        Checkout co = new Checkout(null);
        Assertions.assertThrows(InvalidInput.class, () -> co.scan(null));
    }

    @DisplayName("Cart with total price greater then expected so apply discount and return total")
    @Test
    public void whenCartWithDifferentProductsThenReturnTotalPrice() throws InvalidInput {
        String expectedPrice = "£54.25";
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);

        PromotionalRules promotionalRules = new PromotionalRules();
        promotionalRules.buyMultipleSameProductsAndReduceProductPrice(item1,2, 8.50);
        promotionalRules.applyTotalDiscountOnCart(60, 10);

        Checkout co = new Checkout(promotionalRules);
        co.scan(item1);
        co.scan(item2);

        String price = co.total();
        assertEquals(price, expectedPrice);
    }

    @DisplayName("Cart with total price greater then expected so apply discount and return total")
    @Test
    public void whenCartWithTotalPriceAboveDiscountTotalThenApplyDiscountReturnDiscountedTotal() throws InvalidInput {
        String expectedPrice = "£66.78";
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);

        PromotionalRules promotionalRules = new PromotionalRules();
        promotionalRules.buyMultipleSameProductsAndReduceProductPrice(item1,2, 8.50);
        promotionalRules.applyTotalDiscountOnCart(60, 10);

        Checkout co = new Checkout(promotionalRules);
        co.scan(item1);
        co.scan(item2);
        co.scan(item3);

        String price = co.total();
        assertEquals(price, expectedPrice);
    }

    @DisplayName("Cart with same product so reduce price and apply discount and return total")
    @Test
    public void whenCartWithSamePromotionalProductTypeThenApplyDiscountAndReturnTotal() throws InvalidInput {
        String expectedPrice = "£36.95";
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);

        PromotionalRules promotionalRules = new PromotionalRules();
        promotionalRules.buyMultipleSameProductsAndReduceProductPrice(item1,2, 8.50);
        promotionalRules.applyTotalDiscountOnCart(60, 10);

        Checkout co = new Checkout(promotionalRules);
        co.scan(item1);
        co.scan(item3);
        co.scan(item1);
        String price = co.total();
        assertEquals(price, expectedPrice);
    }

    @DisplayName("Cart with same product so reduce price and total price still greater then expected so apply discount and return total")
    @Test
    public void whenCartWithSamePromotionalProductTypeAndTotalPriceAboveDiscountThenApplyDiscountAndReturnTotal() throws InvalidInput {
        String expectedPrice = "£73.76";
        Product travelCardHolder = new Product("001", "Travel Card Holder", 9.25);
        Product personalisedCufflinks = new Product("002", "Personalised cufflinks", 45.00);
        Product kidsTShirt = new Product("003", "Kids T-shirt", 19.95);

        PromotionalRules promotionalRules = new PromotionalRules();
        promotionalRules.buyMultipleSameProductsAndReduceProductPrice(travelCardHolder,2, 8.50);
        promotionalRules.applyTotalDiscountOnCart(60, 10);
        Checkout co = new Checkout(promotionalRules);
        co.scan(travelCardHolder);
        co.scan(personalisedCufflinks);
        co.scan(travelCardHolder);
        co.scan(kidsTShirt);

        String price = co.total();
        assertEquals(price, expectedPrice);
    }

    @DisplayName("No Promotions so return total price")
    @Test
    public void whenNoPromotionsThenReturnTotal() throws InvalidInput {
        String expectedPrice = "£83.45";
        Product travelCardHolder = new Product("001", "Travel Card Holder", 9.25);
        Product personalisedCufflinks = new Product("002", "Personalised cufflinks", 45.00);
        Product kidsTShirt = new Product("003", "Kids T-shirt", 19.95);

        PromotionalRules promotionalRules = new PromotionalRules();

        Checkout co = new Checkout(promotionalRules);
        co.scan(travelCardHolder);
        co.scan(personalisedCufflinks);
        co.scan(travelCardHolder);
        co.scan(kidsTShirt);

        String price = co.total();
        assertEquals(price, expectedPrice);
    }
}