package com.checkout.services;

import com.checkout.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @DisplayName("Add null product then return 0 total price")
    @Test
    public void addNullProductsToCartAndReturnPrice() {
        double expectedPrice = 0.0;

        Cart cart = new Cart();
        cart.addProduct(null);
        cart.addProduct(null);

        assertEquals(expectedPrice, cart.getTotalPrice());
        assertEquals(0, cart.getItems().size());
    }

    @DisplayName("Add 2 valid and 1 null product to cart and return cart with products and total price")
    @Test
    public void addNullAndValidProductsToCartAndReturnPrice() {
        double expectedPrice = 64.95;
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);

        Cart cart = new Cart();
        cart.addProduct(null);
        cart.addProduct(item2);
        cart.addProduct(item3);

        assertEquals(expectedPrice, cart.getTotalPrice());
        assertEquals(2, cart.getItems().size());
    }

    @DisplayName("Add 3 products to Cart and return cart with products and total price")
    @Test
    public void AddProductsToCartAndReturnPrice() {
        double expectedPrice = 74.20;
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);

        Cart cart = new Cart();
        cart.addProduct(item1);
        cart.addProduct(item2);
        cart.addProduct(item3);

        assertEquals(expectedPrice, cart.getTotalPrice());
        assertEquals(3, cart.getItems().size());
    }

    @DisplayName("Add products and apply discount to cart and return discounted total price")
    @Test
    public void addProductsAndApplyDiscountThenReturnDiscountedTotalPrice() {
        double expectedPrice = 64.20;
        Product item1 = new Product("001", "Travel Card Holder", 9.25);
        Product item2 = new Product("002", "Personalised cufflinks", 45.00);
        Product item3 = new Product("003", "Kids T-shirt", 19.95);

        Cart cart = new Cart();
        cart.addProduct(item1);
        cart.addProduct(item2);
        cart.addProduct(item3);
        cart.applyDiscount(10);

        assertEquals(expectedPrice, cart.getTotalPrice());
        assertEquals(3, cart.getItems().size());
    }
}