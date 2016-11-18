package com.boku.shopping.products;

/**
 * Product with not eligible the local sales tax.
 * 
 * @author Rohit Gupta
 *
 */
public class BasicNonTaxableProduct extends Product {

    /**
     * construct the Non-Taxable product with specified properties
     * 
     * @param quantity
     * @param name
     * @param basicPrice
     * @param imported
     * @param productDesc
     */
    public BasicNonTaxableProduct(int quantity, double basicPrice, boolean imported,
            String productDesc) {
        super(quantity, basicPrice, imported, productDesc);
    }

    /**
     * Tax will be 0 for non-taxable products
     */
    @Override
    public Double calculateTax() {
        return 0.0D;
    }

}
