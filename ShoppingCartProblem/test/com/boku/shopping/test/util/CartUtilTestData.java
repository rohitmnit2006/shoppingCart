package com.boku.shopping.test.util;

import com.boku.shopping.input.ShoppingCart;
import com.boku.shopping.products.BasicNonTaxableProduct;
import com.boku.shopping.products.BasicTaxableProduct;

/**
 * 
 * @author Rohit Gupta
 */

public class CartUtilTestData {

    public static ShoppingCart createNonTaxableProductCart(boolean taxable) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductToCart(new BasicNonTaxableProduct(1, 20.0, taxable, "Test1"));
        cart.addProductToCart(new BasicNonTaxableProduct(1, 30.0, taxable, "Test2"));
        cart.addProductToCart(new BasicNonTaxableProduct(1, 50.0, taxable, "Test3"));
        return cart;
    }

    public static ShoppingCart createTaxableProductCart(boolean taxable) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductToCart(new BasicTaxableProduct(1, 20.0, taxable, "Test1"));
        cart.addProductToCart(new BasicTaxableProduct(1, 30.0, taxable, "Test2"));
        cart.addProductToCart(new BasicTaxableProduct(1, 50.0, taxable, "Test3"));
        return cart;
    }

    public static ShoppingCart createMixTaxableProductCart(boolean taxable) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProductToCart(new BasicTaxableProduct(1, 20.0, taxable, "Test1"));
        cart.addProductToCart(new BasicTaxableProduct(1, 30.0, taxable, "Test2"));
        cart.addProductToCart(new BasicTaxableProduct(1, 50.0, taxable, "Test3"));
        cart.addProductToCart(new BasicNonTaxableProduct(1, 20.0, taxable, "Test1"));
        cart.addProductToCart(new BasicNonTaxableProduct(1, 30.0, taxable, "Test2"));
        cart.addProductToCart(new BasicNonTaxableProduct(1, 50.0, taxable, "Test3"));
        return cart;
    }
}
