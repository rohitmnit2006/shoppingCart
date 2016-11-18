/**
 * 
 */
package com.boku.shopping.receipt;

/**
 * @author Rohit Gupta
 * 
 *         print the receipt which include all the items in the cart with updated price including
 *         tax and total amount to be paid for the cart.
 */
public interface Receipt {

    /** print the receipt in the desired format*/
    public void printReceipt();
}
