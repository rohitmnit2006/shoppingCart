package com.boku.shopping.calculator;

import com.boku.shopping.products.Product;

/**
 * 
 * TaxCalculator contract for calculating the tax of the product
 * 
 * @author Rohit Gupta
 *
 */
public interface TaxCalculator {

    /**
     * Calculate the tax on product
     * 
     * @param product
     * @return tax amount
     */

    public Double calculateTax(Product product);

}
