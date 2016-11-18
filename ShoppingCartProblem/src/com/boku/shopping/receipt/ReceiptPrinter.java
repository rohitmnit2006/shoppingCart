package com.boku.shopping.receipt;

import com.boku.shopping.input.ShoppingCart;
import com.boku.shopping.products.Product;
import com.boku.shopping.util.RoundValueUtility;

/**
 * The Receipt is the string representation of the products purchased with their taxed cost, the
 * total tax and total amount payable.
 *
 * @author Rohit Gupta
 */
public class ReceiptPrinter implements Receipt {

    private final ShoppingCart shoppingCart;

    public ReceiptPrinter(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /** print the receipt object */
    @Override
    public void printReceipt() {
        System.out.println(this);
    }


    /** override the object toString method to delegate the formate required for receipt printing */
    @Override
    public String toString() {
        String receipt = "";
        // print each product in cart in output formate
        for (Product p : shoppingCart.getProductsFromCart()) {
            receipt += (p.toString() + "\n");
        }

        receipt += "Sales Taxes: "
                + RoundValueUtility.toString(shoppingCart.getTotalSalesTax()) + "\n";
        receipt += "Total: " + RoundValueUtility.toString(shoppingCart.getTotalAmount())
                + "\n";

        return receipt;
    }

}
