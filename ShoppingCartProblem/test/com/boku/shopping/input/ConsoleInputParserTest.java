package com.boku.shopping.input;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.Test;

import com.boku.shopping.products.BasicTaxableProduct;
import com.boku.shopping.products.Product;

/**
 * 
 * @author Rohit Gupta
 */

public class ConsoleInputParserTest {

    @Test
    public void product_should_extract_from_input_line() {

        ConsoleInputParser consoleInputParser = new ConsoleInputParser();

        try {
            Method method =
                    ConsoleInputParser.class.getDeclaredMethod("getProductFromLine", String.class);

            method.setAccessible(true);

            Product product = (Product) method.invoke(consoleInputParser,
                    "1 imported bottle of perfume at 27.99");

            assertTrue(product instanceof BasicTaxableProduct);
            assertTrue(product.getBasicPrice() == 27.99);
            assertTrue(product.getQuantity() == 1);
            assertTrue(product.getProductDesc().equals("bottle of perfume"));
            assertTrue(product.isImported());

        } catch (Exception e) {
            fail("Exception should not come");
        }
    }
}
