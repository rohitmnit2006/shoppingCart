package com.boku.shopping.input;

import org.junit.Test;

import com.boku.shopping.products.BasicNonTaxableProduct;
import com.boku.shopping.products.BasicTaxableProduct;
import com.boku.shopping.products.Product;

import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Rohit Gupta
 */

public class ShoppingCartTest {

    private ShoppingCart shoppingCart;

    @Test
    public void addProduct_should_add_product_toCart() {
        shoppingCart = new ShoppingCart();
        Product product = createNonTaxableProduct();
        shoppingCart.addProductToCart(product);
        assertTrue(shoppingCart.getCartSize() == 1);
        assertTrue(shoppingCart.getProductsFromCart().size() == 1);
    }

    @Test
    public void addProduct_should_increse_cart_size() {

        shoppingCart = new ShoppingCart();
        Product product = createNonTaxableProduct();
        shoppingCart.addProductToCart(product);

        assertTrue(shoppingCart.getCartSize() == 1);

        shoppingCart.addProductToCart(createTaxableProduct());
        assertTrue(shoppingCart.getCartSize() == 2);
    }


    @Test
    public void getProduct_should_return_product_addedTo_cart() {
        shoppingCart = new ShoppingCart();
        Product product = createNonTaxableProduct();
        shoppingCart.addProductToCart(product);
        assertTrue(shoppingCart.getCartSize() == 1);
        assertTrue(shoppingCart.getProductsFromCart().get(0) == product);
    }

    @Test
    public void addToCart_total_price_should_increment_total() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addToCartTotalPrice(100.0);
        assertTrue(shoppingCart.getTotalAmount() == 100.0);

        shoppingCart.addToCartTotalPrice(10.0);

        assertTrue(shoppingCart.getTotalAmount() == 110.0);
    }

    @Test
    public void addToCart_Tax_price_should_increment_total() {
        shoppingCart = new ShoppingCart();
        shoppingCart.addToCartTotalTax(100.0);
        assertTrue(shoppingCart.getTotalSalesTax() == 100.0);

        shoppingCart.addToCartTotalTax(20.0);
        assertTrue(shoppingCart.getTotalSalesTax() == 120.0);
    }


    private Product createNonTaxableProduct() {
        return new BasicNonTaxableProduct(1, 20.0, false, "Test1");
    }

    private Product createTaxableProduct() {
        return new BasicTaxableProduct(1, 20.0, false, "Test1");
    }

}
