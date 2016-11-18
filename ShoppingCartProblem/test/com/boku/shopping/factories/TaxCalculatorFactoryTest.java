package com.boku.shopping.factories;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.boku.shopping.calculator.BasicTaxCalculator;
import com.boku.shopping.calculator.ImportTaxCalculator;
import com.boku.shopping.calculator.TaxCalculator;

/**
 * 
 * @author Rohit Gupta
 */

public class TaxCalculatorFactoryTest {

    @Test
    public void should_return_basic_tax_calculator() {
        TaxCalculator calculator = TaxCalculatorFactory.getTaxCalculator("basic");
        assertTrue(calculator instanceof BasicTaxCalculator);
    }

    @Test
    public void should_return_import_tax_calculator() {
        TaxCalculator calculator = TaxCalculatorFactory.getTaxCalculator("import");
        assertTrue(calculator instanceof ImportTaxCalculator);
    }

    @Test
    public void should_return_same_tax_calculator() {
        TaxCalculator calculator1 = TaxCalculatorFactory.getTaxCalculator("basic");
        TaxCalculator calculator2 = TaxCalculatorFactory.getTaxCalculator("basic");
        assertTrue(calculator1 == calculator2);
    }

}
