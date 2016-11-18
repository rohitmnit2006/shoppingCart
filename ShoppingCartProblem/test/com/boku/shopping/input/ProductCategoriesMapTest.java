package com.boku.shopping.input;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.boku.shopping.util.ProductTypeEnum;

/**
 * 
 * @author Rohit Gupta
 */

public class ProductCategoriesMapTest {

    ProductCategoriesMap categoriesMap;

    @Test
    public void should_able_add_new_product() {

        categoriesMap = new ProductCategoriesMap();

        categoriesMap.addProductToCategoryMap("Fan", ProductTypeEnum.TAXABLE);

        assertTrue(categoriesMap.getTheProductType("Fan")
                .equalsIgnoreCase(ProductTypeEnum.TAXABLE.getValue()));
    }

    @Test
    public void should_able_to_fetch_existing_product() {

        categoriesMap = new ProductCategoriesMap();

        assertTrue(categoriesMap.getTheProductType("book")
                .equalsIgnoreCase(ProductTypeEnum.NON_TAXABLE.getValue()));

        assertTrue(categoriesMap.getTheProductType("bottle of perfume")
                .equalsIgnoreCase(ProductTypeEnum.TAXABLE.getValue()));
    }
}
