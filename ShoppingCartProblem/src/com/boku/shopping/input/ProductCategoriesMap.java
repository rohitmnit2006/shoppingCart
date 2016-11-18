package com.boku.shopping.input;

import java.util.HashMap;
import java.util.Map;

import com.boku.shopping.util.ProductTypeEnum;

/**
 * Map class to categorize the product input by the user into taxable and non-taxable type.
 * 
 * @author Rohit Gupta
 *
 */

public class ProductCategoriesMap {

    /** The product items mapped to their respective categories */
    private static Map<String, String> productCategoriesMap;

    /**
     * Instantiates a new store shelf with the product items.
     */
    public ProductCategoriesMap() {
        productCategoriesMap = new HashMap<String, String>();
        addProductToCategoryMap("book", ProductTypeEnum.NON_TAXABLE);
        addProductToCategoryMap("music CD", ProductTypeEnum.TAXABLE);
        addProductToCategoryMap("chocolate bar", ProductTypeEnum.NON_TAXABLE);
        addProductToCategoryMap("box of chocolates", ProductTypeEnum.NON_TAXABLE);
        addProductToCategoryMap("bottle of perfume", ProductTypeEnum.TAXABLE);
        addProductToCategoryMap("packet of headache pills", ProductTypeEnum.NON_TAXABLE);
    }

    /**
     * Adds the product items to store shelf in their respective categories.
     *
     * @param productItem - the product item
     * @param productCategory - the product category to which a particular item belongs.
     */
    public void addProductToCategoryMap(String productItem, ProductTypeEnum productCategory) {
        productCategoriesMap.put(productItem, productCategory.getValue());

    }

    /**
     * Searches for the item using the string name and maps it to the product category to create a
     * new Product object.
     *
     * @param name - name of the product
     * @return productType - Taxable/NonTaxable
     */
    public String getTheProductType(String name) {

        return productCategoriesMap.get(name);
    }

}
