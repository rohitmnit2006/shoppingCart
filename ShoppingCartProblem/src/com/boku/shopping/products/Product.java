package com.boku.shopping.products;

import com.boku.shopping.util.RoundValueUtility;

/**
 * @author Rohit Gupta
 *
 */
public abstract class Product {

    /** productDesc - product description */
    private final String productDesc;

    /** price - original price of the single product excluding tax */
    private final Double basicPrice;

    /** imported - boolean value which indicates whether product is imported or not. */
    private final Boolean imported;

    /** quantity - the quantity of the product to be purchased. */
    private final int quantity;

    /** totalCostIncludingTax - the net price of the all products of same type including tax. */
    private Double totalCostIncludingTax = 0.0d;

    /**
     * Parameterized constructor to initialize the values of the product attributes.
     *
     * @param basicPrice - the price of the product
     * @param quantity - quantity of product item
     * @param imported - boolean value of whether product imported or not
     */
    public Product(int quantity, Double basicPrice, Boolean imported, String productDesc) {
        this.quantity = quantity;
        this.basicPrice = basicPrice;
        this.imported = imported;
        this.productDesc = productDesc;
        this.totalCostIncludingTax = basicPrice * quantity;
    }


    public abstract Double calculateTax();


    public Boolean isImported() {
        return imported;
    }

    public Double getBasicPrice() {
        return basicPrice;
    }

    public Boolean getImported() {
        return imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductDesc() {
        return productDesc;
    }


    /** price of the all products of that type */
    public Double getTotalCostExcludingTax() {
        return basicPrice * quantity;
    }

    public Double getTotalCostIncludingTax() {
        return totalCostIncludingTax;
    }


    public void addTaxedCostToPrice(Double taxedCost) {
        this.totalCostIncludingTax += taxedCost;
        this.totalCostIncludingTax = RoundValueUtility.truncate(this.totalCostIncludingTax);
    }


    @Override
    public String toString() {
        return (quantity + " " + toString(imported) + productDesc + " : "
                + RoundValueUtility.toString(this.totalCostIncludingTax));
    }

    /**
     * Gets a String representation for the <code>imported</code> attribute.
     *
     * @param imported - boolean value for imported
     * @return String
     */
    private String toString(boolean imported) {
        return imported?"imported ":"";
    }

}
