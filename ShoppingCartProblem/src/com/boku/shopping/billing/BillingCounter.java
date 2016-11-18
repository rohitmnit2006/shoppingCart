package com.boku.shopping.billing;

import com.boku.shopping.calculator.TaxCalculator;
import com.boku.shopping.factories.TaxCalculatorFactory;
import com.boku.shopping.input.ShoppingCart;
import com.boku.shopping.products.Product;
import com.boku.shopping.util.TaxTypeEnum;


/**
 * Generate the bill by calculating the tax on each #Product in {@link #shoppingCart} also update
 * the product in cart with new price.
 * 
 * @author Rohit Gupta
 * 
 */

public class BillingCounter implements Billing {

    private final ShoppingCart shoppingCart;

    public BillingCounter(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    /**
     * Iterate over each product in cart and calculate tax based on the product type and applicable
     * tax
     */
    @Override
    public void generateBill() {

        for (Product product : shoppingCart.getProductsFromCart()) {

            /** calculate the basic tax of product and add the product tax amount to price */
            product.addTaxedCostToPrice(product.calculateTax());

            /**
             * will check the import flat if its true will calculate the import tax by getting
             * {@link #ImportTaxCalculator}
             */
            if (product.isImported()) {
                TaxCalculator calculator =
                        TaxCalculatorFactory.getTaxCalculator(TaxTypeEnum.IMPORT.getValue());
                product.addTaxedCostToPrice(calculator.calculateTax(product));
            }
            /** update the cart with the latest price including calculated tax values */
            updateCartTotal(product);
        }
    }

    /**
     * After calculating tax on each product sum it for final printing
     * 
     * @param #product - cart will be updated with the values of this product
     */
    private void updateCartTotal(final Product product) {
        shoppingCart.addToCartTotalPrice(product.getTotalCostIncludingTax());
        shoppingCart.addToCartTotalTax(
                product.getTotalCostIncludingTax() - (product.getTotalCostExcludingTax()));
    }
}
