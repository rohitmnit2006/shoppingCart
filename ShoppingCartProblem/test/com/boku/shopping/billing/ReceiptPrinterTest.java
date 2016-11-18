package com.boku.shopping.billing;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import com.boku.shopping.input.ShoppingCart;
import com.boku.shopping.receipt.ReceiptPrinter;
import com.boku.shopping.test.util.CartUtilTestData;

/**
 * 
 * @author Rohit Gupta
 */

public class ReceiptPrinterTest {

    private ReceiptPrinter receiptPrinter;

    @Test
    public void printReceipt_shouldPrintTheReceipt() {
        ShoppingCart cart = CartUtilTestData.createNonTaxableProductCart(true);
        cart.addToCartTotalPrice(115.0);
        cart.addToCartTotalTax(15.0);

        receiptPrinter = new ReceiptPrinter(cart);
        receiptPrinter.printReceipt();

        assertTrue(receiptPrinter.toString().contains("115.00"));
        assertTrue(receiptPrinter.toString().contains("15.00"));
        assertTrue(receiptPrinter.toString().contains("20.00"));
        assertTrue(receiptPrinter.toString().contains("30.00"));
        assertTrue(receiptPrinter.toString().contains("50.00"));
        assertTrue(receiptPrinter.toString().contains("Test1"));
        assertTrue(receiptPrinter.toString().contains("Test2"));
        assertTrue(receiptPrinter.toString().contains("Test3"));
        assertTrue(receiptPrinter.toString().contains("Sales Taxes"));
        assertTrue(receiptPrinter.toString().contains("Total"));
    }

}
