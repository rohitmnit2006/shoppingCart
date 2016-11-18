package com.boku.shopping.input;

import java.util.ArrayList;
import java.util.List;

import com.boku.shopping.products.Product;

/**
 * This class is to add the product into cart
 * 
 * @author Rohit Gupta
 *
 */
public class ShoppingCart {

    /** A list to store the products. */
    private final List<Product> productList;

    /** Sum of amount payable by the customer including tax for each product in cart */
    private Double totalAmount;

    /** Sum of sales tax calculated on each product in cart */
    private Double totalSalesTax;

    /**
     * Instantiates a new shopping cart to which products can be added.
     */

    public ShoppingCart() {
        productList = new ArrayList<Product>();
        totalAmount = 0.0D;
        totalSalesTax = 0.0D;
    }

    /**
     * Adds the item to the cart.
     *
     * @param product - the product to be added to the cart.
     */
    public void addProductToCart(Product product) {
        productList.add(product);
    }

    /**
     * Retrieves the items from cart.
     *
     * @return a list containing Products
     */
    public List<Product> getProductsFromCart() {
        return productList;
    }

    /**
     * Gets the number of products in the cart.
     *
     * @return int
     */
    public int getCartSize() {
        return productList.size();
    }

    /**
     * add amount to total payable amount
     * 
     * @param amount
     */
    public void addToCartTotalPrice(Double amount) {
        totalAmount += amount;
    }

    /**
     * add the amount to total tax
     * 
     * @param tax : calculated tax on the product
     */
    public void addToCartTotalTax(Double tax) {
        totalSalesTax += tax;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getTotalSalesTax() {
        return totalSalesTax;
    }

}
