package com.boku.shopping.tax.calculator.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.boku.shopping.calculator.BasicTaxCalculator;
import com.boku.shopping.products.BasicTaxableProduct;
import com.boku.shopping.products.Product;

/**
 * 
 * @author Rohit Gupta
 */

public class BasicTaxCalculatorTest {

    private BasicTaxCalculator basicTaxCalculator;

    @Before
    public void setUp() {
        basicTaxCalculator = new BasicTaxCalculator();
    }

    @Test
    public void should_Calculate_basic_tax() {
        Product product = createTaxableProduct(false);
        double tax = basicTaxCalculator.calculateTax(product);
        assertTrue(tax == 2.0);
    }

    @Test
    public void should_not_calculate_import_tax() {
        Product product = createTaxableProduct(true);
        double tax = basicTaxCalculator.calculateTax(product);
        assertTrue(tax == 2.0);
    }


    private Product createTaxableProduct(boolean imported) {
        return new BasicTaxableProduct(1, 20.0, imported, "Test1");
    }

}
