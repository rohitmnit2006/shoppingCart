package com.boku.shopping.billing;

/**
 * This is for generating the bill for the items in cart. 
 * 
 * @author Rohit Gupta
 */
public interface Billing {

    /** Calculate the tax on each product in cart based on product and tax type */
    public void generateBill();
}
