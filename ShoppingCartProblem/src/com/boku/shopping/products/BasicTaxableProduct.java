package com.boku.shopping.products;

import com.boku.shopping.calculator.TaxCalculator;
import com.boku.shopping.factories.TaxCalculatorFactory;
import com.boku.shopping.util.TaxTypeEnum;

/**
 * Product with eligible the local sales tax.
 * 
 * @author Rohit Gupta
 *
 */
public class BasicTaxableProduct extends Product {

    /**
     * construct the Taxable product with specified properties
     * 
     * @param quantity
     * @param name
     * @param basicPrice
     * @param imported
     * @param productDesc
     */

    public BasicTaxableProduct(int quantity, double basicPrice, boolean imported,
            String productDesc) {
        super(quantity, basicPrice, imported, productDesc);
    }

    /**
     * Calculate the tax based on basic rate
     */

    @Override
    public Double calculateTax() {
        TaxCalculator calculator =
                TaxCalculatorFactory.getTaxCalculator(TaxTypeEnum.BASIC.getValue());
        return calculator.calculateTax(this);
    }

}
