package com.boku.shopping.tax.calculator.service;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.boku.shopping.calculator.ImportTaxCalculator;
import com.boku.shopping.products.BasicTaxableProduct;
import com.boku.shopping.products.Product;

/**
 * 
 * @author Rohit Gupta
 */

public class ImportTaxCalculatorTest {

    private ImportTaxCalculator importTaxCalculator;

    @Before
    public void setUp() {
        importTaxCalculator = new ImportTaxCalculator();
    }

    @Test
    public void should_Calculate_basic_tax() {
        Product product = createTaxableProduct(false);
        double tax = importTaxCalculator.calculateTax(product);
        assertTrue(tax == 1.0);
    }

    @Test
    public void should_not_calculate_import_tax() {
        Product product = createTaxableProduct(true);
        double tax = importTaxCalculator.calculateTax(product);
        assertTrue(tax == 1.0);
    }


    private Product createTaxableProduct(boolean imported) {
        return new BasicTaxableProduct(1, 20.0, imported, "Test1");
    }

}
