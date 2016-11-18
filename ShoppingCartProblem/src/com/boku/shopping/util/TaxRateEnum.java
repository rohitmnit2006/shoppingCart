/**
 * 
 */
package com.boku.shopping.util;

/**
 * Enum for different type of Tax
 * 
 * @author Rohit Gupta
 *
 */
public enum TaxRateEnum {

    BASIC_TAX(0.10), IMPORT_TAX(0.05);

    private Double value;

    TaxRateEnum(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

}
