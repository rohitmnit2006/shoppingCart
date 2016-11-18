package main;

import com.boku.shopping.billing.Billing;
import com.boku.shopping.billing.BillingCounter;
import com.boku.shopping.input.ConsoleInputParser;
import com.boku.shopping.input.ShoppingCart;
import com.boku.shopping.receipt.Receipt;
import com.boku.shopping.receipt.ReceiptPrinter;

/**
 * main program to read input and print receipt on console
 * 
 * @author Rohit Gupta
 *
 */

public class MainApp {

    public static void main(String[] args) {

        System.out.println("Please provide the input followed by one blank line:");

        ConsoleInputParser inputParser = new ConsoleInputParser();
        ShoppingCart shoppingCart = inputParser.addItemToCart();

        Billing billing = new BillingCounter(shoppingCart);
        billing.generateBill();

        Receipt receipt = new ReceiptPrinter(shoppingCart);
        receipt.printReceipt();
    }

}
