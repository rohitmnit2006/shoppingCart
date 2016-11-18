
#The sequence of steps performed are:

1. Read the input from the console. And parse the details related to product.
2. Based on parse productType fetch the category from ProductCategoriesMap (i.e. Taxable or NonTaxable)
3. Add these product in to a shopping cart.
4. The shopping cart is taken to the Billing counter where Tax will be calculated on all the product based on product type. (i.e. Imported or Taxable or NonTaxable).
5. Final step will be to print the receipts after tax calculation on each product.


#Assumption : 

1. Input line will be in following order -
    (quantity) (Imported or not) (product description) at (price) 

2. ProductCategoriesMap  --> Map to contain all different type of product and there type (Taxable , NonTaxable).

3. Input will be finished with 1 blank line . (need to hit enter twice after the last line.)

4.  Used external library for junits (junit-4.11.jar)



#Design :

EntryPoint -> MainApp.java

InputParser -> contract for input (End result will be - products added to cart after parsing the input).
   
    ConsoleInputParser -> implementation on InputParser   

ShoppingCart -> cart is for adding the product (parse input line) into cart.

ProductFactory --> Factory class to generate the different type of product based on category. ( BasicTaxableProduct , BasicNonTaxableProduct).

TaxCalculatorFactory --> Factory to get the Tax calculator based on tax type (Basic, Import).

RoundValueUtility --> utility class for rounding the amount.



#Advantages of the design :

The Product is an abstract superclass and the various types of products like Taxable & NonTaxable products inherit from the Product class. This facilitates extensibility as a new Product type can be added in the future by just extending the Product class.
The advantage of creating a separate class for each product type is, other attributes of the products can be added and they can be integrated with a database so as to facilitate creation of a \
The creation of the new products is done using an  Factory design pattern.

	The advantage of using this pattern is, when new Products are added, there is no need to change existing client code. It is enough to create a new derived factory class.

The tax calculations module is designed using the Factory + Singleton pattern.

	The advantage of using this pattern is that we can add a new algorithm for tax calculation in the future easily and dynamically choose the algorithm at runtime. The actual creation of a tax calculator is delegated to a factory method.

The TaxRateEnum is an enum which contains the tax values of various categories.

A RoundValueUtility class provides rounding and truncating functions to assist in the tax calculations.

The various combinations of input are tested using Junit test cases.
