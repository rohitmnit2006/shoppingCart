package com.boku.shopping.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.boku.shopping.factories.ProductFactory;
import com.boku.shopping.products.Product;

/**
 * 
 * Parse the user entered input in to a product and add that product into the shopping cart.
 * 
 * @author Rohit Gupta
 *
 */
public class ConsoleInputParser implements InputParser {

    /** gets user input of products. */
    private final BufferedReader input;

    /** The cart holds the purchased items to be billed. */
    private final ShoppingCart sc;

    /** Contains the mapping of product to there type */
    private ProductCategoriesMap productCategoriesMap;

    public ConsoleInputParser() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
        this.sc = new ShoppingCart();
        this.productCategoriesMap = new ProductCategoriesMap();
    }


    /** Read the input from the console until encounter a blank line */
    @Override
    public ShoppingCart addItemToCart() {
        try {
            String line = null;
            while (!(line = input.readLine()).trim().equals("")) {
                Product product = getProductFromLine(line);
                sc.addProductToCart(product);
            }
        } catch (IOException e) {
            System.out.println("Exception while reading the input");
        }
        return sc;
    }


    /**
     * Since each line in the input has 3 parts 1. quantity 2. product description 3. price
     */
    private Product getProductFromLine(String line) {

        // split the line by space " " .
        String[] tokenize = line.split(" ");

        /** first entry is quantity */
        Integer quantity = Integer.valueOf(tokenize[0]);

        /** last entry is price */
        Double basicPrice = Double.valueOf(tokenize[tokenize.length - 1]);

        /** if input line contains imported that mean its imported product */
        Boolean isImported = line.contains("imported");

        /** remaining part is product description */
        String productDesc = getProductDesc(line, tokenize, isImported);

        /** get the product from product factory based on product type */
        return ProductFactory.getProduct(quantity,
                productCategoriesMap.getTheProductType(productDesc), basicPrice, isImported,
                productDesc);
    }

    /**
     * product desc will be between 'quantity' and 'at #price' if imported then remove from the desc
     *
     * @param line : input from the user
     * @param tokenize : convert the input in to array
     * @param isImported : boolean value representing imported or not.
     * @return
     */
    private String getProductDesc(String line, String[] tokenize, Boolean isImported) {
        String productdesc = line.substring(tokenize[0].length(),
                line.length() - tokenize[tokenize.length - 1].length() - 3);
        if (isImported) {
            productdesc = productdesc.replace("imported ", "");
        }
        return productdesc.trim();
    }

}
