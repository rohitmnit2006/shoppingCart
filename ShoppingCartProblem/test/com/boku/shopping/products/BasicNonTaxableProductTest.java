package com.boku.shopping.products;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Rohit Gupta
 */

public class BasicNonTaxableProductTest {

    @Test
    public void created_object_should_have_specified_values() {

        int quantity = 2;
        Double basicPrice = 25.5;
        Boolean imported = true;
        String productDesc = " test product ";
        BasicNonTaxableProduct basicNonTaxableProduct =
                new BasicNonTaxableProduct(quantity, basicPrice, imported, productDesc);

        assertTrue(basicNonTaxableProduct.getProductDesc().equalsIgnoreCase(productDesc));
        assertTrue(basicNonTaxableProduct.getQuantity() == quantity);
        assertTrue(basicNonTaxableProduct.isImported());
        assertTrue(
                basicNonTaxableProduct.getBasicPrice().doubleValue() == basicPrice.doubleValue());
    }


    @Test
    public void calculate_tax_should_be_zero() {

        int quantity = 2;
        Double basicPrice = 25.5;
        Boolean imported = true;
        String productDesc = "test product";
        BasicNonTaxableProduct basicNonTaxableProduct =
                new BasicNonTaxableProduct(quantity, basicPrice, imported, productDesc);

        double tax = basicNonTaxableProduct.calculateTax();
        assertTrue(tax == 0.0);
    }
}
