package com.boku.shopping.input;

/**
 * A parser contract for diffrent type of input reader - (console or file)
 * 
 * @author Rohit Gupta
 *
 */
public interface InputParser {

    public ShoppingCart addItemToCart();
}
