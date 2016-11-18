package com.boku.shopping.factories;

import com.boku.shopping.products.BasicNonTaxableProduct;
import com.boku.shopping.products.BasicTaxableProduct;
import com.boku.shopping.products.Product;
import com.boku.shopping.util.ProductTypeEnum;

/**
 * factory class to create a new Taxable or NonTaxable object with specified properties. Default is
 * taxable product.
 * 
 * @author Rohit Gupta
 */
public class ProductFactory {

    /**
     * Creates a new Product object.
     * 
     * @param quantity - quantity of product
     * @param price - price of product
     * @param imported - boolean value of whether imported or not
     * @param productDesc - name of the product
     * @return Product
     */

    public static Product getProduct(int quantity, String type, Double basicPrice, Boolean imported,
            String productDesc) {
        /** if its of type non taxable create non taxable product */
        if (ProductTypeEnum.NON_TAXABLE.getValue().equalsIgnoreCase(type)) {
            return new BasicNonTaxableProduct(quantity, basicPrice, imported, productDesc);
        }

        return new BasicTaxableProduct(quantity, basicPrice, imported, productDesc);

    }

}
