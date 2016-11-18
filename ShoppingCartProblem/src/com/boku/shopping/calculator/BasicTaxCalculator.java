package com.boku.shopping.calculator;

import com.boku.shopping.products.Product;
import com.boku.shopping.util.RoundValueUtility;
import com.boku.shopping.util.TaxRateEnum;

/**
 * Calculate the basic local sales tax of the product.
 * 
 * @author Rohit Gupta
 *
 */

public class BasicTaxCalculator implements TaxCalculator {

    @Override
    public Double calculateTax(Product product) {

        // Calculates tax cost
        double tax = product.getTotalCostExcludingTax() * TaxRateEnum.BASIC_TAX.getValue();

        // rounds off to nearest 0.05 cents
        tax = RoundValueUtility.roundoff(tax);

        return tax;

    }

}
