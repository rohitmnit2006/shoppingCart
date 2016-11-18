package com.boku.shopping.util;

/**
 * 
 * Enaum to define the diffrent type of products
 * 
 * @author Rohit Gupta
 *
 */
public enum ProductTypeEnum {

    TAXABLE("taxable"), NON_TAXABLE("nonTaxable");

    private String value;

    ProductTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
