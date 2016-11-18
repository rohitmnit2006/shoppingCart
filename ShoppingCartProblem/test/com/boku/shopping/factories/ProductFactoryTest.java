package com.boku.shopping.factories;

import org.junit.Test;

import com.boku.shopping.products.BasicNonTaxableProduct;
import com.boku.shopping.products.BasicTaxableProduct;
import com.boku.shopping.products.Product;

import static org.junit.Assert.assertTrue;

/**
 * 
 * @author Rohit Gupta
 */

public class ProductFactoryTest {

    @Test
    public void non_taxable_product_shouldCreate_for_same_type() {

        Product product = ProductFactory.getProduct(1, "nonTaxable", 10.0, true, "Test1");

        assertTrue(product instanceof BasicNonTaxableProduct);
    }

    @Test
    public void taxable_product_shouldCreate_for_same_type() {

        Product product = ProductFactory.getProduct(1, "taxable", 10.0, true, "Test1");

        assertTrue(product instanceof BasicTaxableProduct);
    }

}
