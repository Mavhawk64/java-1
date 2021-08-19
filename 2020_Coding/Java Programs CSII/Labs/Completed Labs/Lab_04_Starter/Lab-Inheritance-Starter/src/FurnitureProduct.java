// COURSE: CSCI1620
// TERM: Spring 2018
//
// NAME: <YOUR NAME>
// RESOURCES: <COMPLETE>

/**
 * The FurnitureProduct class is the base class for all products sold in a furniture store.
 * It contains the two things that all furniture products have, a name and product number.
 */
public class FurnitureProduct
{
	/**
	 * The smallest allowed value for a product number, set to 10000.
	 */
	private static final int MINIMUM_PRODUCT_NUMBER = 10000;
	/**
	 * The largest allowed value for a product number, set to 99999.
	 */
	private static final int MAXIMUM_PRODUCT_NUMBER = 99999;	
	/**
	 * The name of the product.
	 */
	private String productName;
	/**
	 * The number of the product. An invalid product number will be denoted by a -1.
	 */
	private int productNumber;
	

}
