package com.boku.shopping.products;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Rohit Gupta
 */

public class BasicTaxableProductTest {

    @Test
    public void created_object_should_have_specified_values() {

        int quantity = 2;
        Double basicPrice = 25.5;
        Boolean imported = true;
        String productDesc = " test product ";
        BasicTaxableProduct basicTaxableProduct =
                new BasicTaxableProduct(quantity, basicPrice, imported, productDesc);

        assertTrue(basicTaxableProduct.getProductDesc().equalsIgnoreCase(productDesc));
        assertTrue(basicTaxableProduct.getQuantity() == quantity);
        assertTrue(basicTaxableProduct.isImported());
        assertTrue(basicTaxableProduct.getBasicPrice().doubleValue() == basicPrice.doubleValue());
    }
    
    
    @Test
    public void calculate_tax_should_not_be_zero() {

        int quantity = 2;
        Double basicPrice = 100.0;
        Boolean imported = true;
        String productDesc = " test product ";
        BasicTaxableProduct basicTaxableProduct =
                new BasicTaxableProduct(quantity, basicPrice, imported, productDesc);

        double tax = basicTaxableProduct.calculateTax();
        assertTrue(tax == 20.0);
    }
}
