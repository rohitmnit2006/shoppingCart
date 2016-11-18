package com.boku.shopping.util;

/**
 * Enum for diffrent type of Tax
 * 
 * @author Rohit Gupta
 *
 */
public enum TaxTypeEnum {

    IMPORT("import"), BASIC("basic");

    private String value;

    TaxTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
