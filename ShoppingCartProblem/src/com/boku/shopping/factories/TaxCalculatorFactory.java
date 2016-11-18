/**
 * 
 */
package com.boku.shopping.factories;

import com.boku.shopping.calculator.BasicTaxCalculator;
import com.boku.shopping.calculator.ImportTaxCalculator;
import com.boku.shopping.calculator.TaxCalculator;
import com.boku.shopping.util.TaxTypeEnum;

/**
 * Factory with single lock singleton pattern for creating the TaxCalculator based on taxType
 * 
 * @author Rohit Gupta
 *
 */
public class TaxCalculatorFactory {

    private static TaxCalculator IMPORT_TAX_INSTANCE = null;
    private static TaxCalculator BASIC_TAX_INSTANCE = null;

    /**
     * depending on the type return the tax calculator
     * 
     * @param taxType
     * @return #TaxCalculator
     */

    public static TaxCalculator getTaxCalculator(String taxType) {

        if (TaxTypeEnum.IMPORT.getValue().equalsIgnoreCase(taxType)) {
            if (IMPORT_TAX_INSTANCE == null) {
                synchronized (TaxCalculator.class) {
                    IMPORT_TAX_INSTANCE = new ImportTaxCalculator();
                }
            }
            return IMPORT_TAX_INSTANCE;
            
        } else if (TaxTypeEnum.BASIC.getValue().equalsIgnoreCase(taxType)) {
            if (BASIC_TAX_INSTANCE == null) {
                synchronized (TaxCalculator.class) {
                    BASIC_TAX_INSTANCE = new BasicTaxCalculator();
                }
            }
            return BASIC_TAX_INSTANCE;
        }
        return null;
    }
}
