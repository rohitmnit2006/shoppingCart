package com.boku.shopping.billing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.boku.shopping.input.ShoppingCart;
import com.boku.shopping.test.util.CartUtilTestData;

/**
 * @author Rohit Gupta
 */

public class BillingCounterTest {

    private BillingCounter billingCounter;

    @Test
    public void generateBill_Should_Calculate_0_Tax_on_nonTaxable_product() {

        ShoppingCart cart = CartUtilTestData.createNonTaxableProductCart(false);
        billingCounter = new BillingCounter(cart);
        billingCounter.generateBill();

        assertTrue(cart.getTotalAmount() == 100.0);
        assertTrue(cart.getTotalSalesTax() == 0.0);
    }

    @Test
    public void generateBill_Should_Calculate_Tax_on_Taxable_product() {

        ShoppingCart cart = CartUtilTestData.createTaxableProductCart(false);
        billingCounter = new BillingCounter(cart);
        billingCounter.generateBill();

        assertTrue(cart.getTotalAmount() == 110.0);
        assertTrue(cart.getTotalSalesTax() == 10.0);
    }

    @Test
    public void generateBill_Should_Calculate_Tax_Mix_Taxable_product() {

        ShoppingCart cart = CartUtilTestData.createMixTaxableProductCart(false);
        billingCounter = new BillingCounter(cart);
        billingCounter.generateBill();

        assertTrue(cart.getTotalAmount() == 210.0);
        assertTrue(cart.getTotalSalesTax() == 10.0);
    }


    @Test
    public void generateBill_Should_Calculate_Tax_on_nonTaxable_Imported_product() {

        ShoppingCart cart = CartUtilTestData.createNonTaxableProductCart(true);
        billingCounter = new BillingCounter(cart);
        billingCounter.generateBill();

        assertTrue(cart.getTotalAmount() == 105.0);
        assertTrue(cart.getTotalSalesTax() == 5.0);
    }


    @Test
    public void generateBill_Should_Calculate_Both_Tax_on_Taxable_Imported_Product() {

        ShoppingCart cart = CartUtilTestData.createTaxableProductCart(true);
        billingCounter = new BillingCounter(cart);
        billingCounter.generateBill();

        assertTrue(cart.getTotalAmount() == 115.0);
        assertTrue(cart.getTotalSalesTax() == 15.0);
    }

    @Test
    public void generateBill_Should_Calculate_both_Tax_Mix_Taxable_Imported_Product() {

        ShoppingCart cart = CartUtilTestData.createMixTaxableProductCart(true);
        billingCounter = new BillingCounter(cart);
        billingCounter.generateBill();

        assertTrue(cart.getTotalAmount() == 220.0);
        assertTrue(cart.getTotalSalesTax() == 20.0);
    }

}
