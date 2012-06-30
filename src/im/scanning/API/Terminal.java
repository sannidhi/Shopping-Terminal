package im.scanning.API;

import java.util.HashMap;
import java.util.Map;

/**
 * This class performs all the functions performed at the terminal such as:
 * Scanning the product, calculating price for it, applying discounts if applicable & calculating total amount due
 * @author Sannidhi
 *
 */
public class Terminal {

	private double total;
	private  Map<Character,Product> productInfo = new HashMap<Character,Product>();
	private  Map<Character,Double> productCost = new HashMap<Character,Double>();
	private  Map<Character,Integer> productOccurence = new HashMap<Character,Integer>();

	/**
	 * This function updates the hash map which keeps a record of the number of times the scanned product has been scanned
	 * @param thisProduct - The product that is scanned at the terminal
	 * @return - The number of times the product has appeared in the scan up till now
	 */

	public int updateProductCount(char thisProduct){
		int count=0;
		if(productOccurence.containsKey(thisProduct)){
			count = productOccurence.get(thisProduct);
			productOccurence.put(thisProduct, count+1);
			return count+1;
		}
		else
			productOccurence.put(thisProduct,1);

		return 1;
	}

	/**
	 * This function calculates the price of the product as and when its scanned
	 * @param thisProduct - The product that is scanned at the terminal
	 * @param occurence - The number of times the product has appeared in the scan up till now
	 */

	public void calculatePrice(char thisProduct, int occurence){
		double presentPrice = 0;
		if(productInfo.get(thisProduct).getDiscount()==0 || 
				(occurence%productInfo.get(thisProduct).getDiscountQuantity()!=0)){
			if(productCost.get(thisProduct)!=null)
				presentPrice = productCost.get(thisProduct);
			productCost.put(thisProduct, presentPrice + productInfo.get(thisProduct).getPricePerUnit());
		}

		else {
			presentPrice = productCost.get(thisProduct);
			productCost.put(thisProduct, presentPrice+productInfo.get(thisProduct).getPricePerUnit()-productInfo.get(thisProduct).getDiscount());
		}

	}
	/**
	 * This function is used to initialize the attributes of the Product at the beginning of every transaction
	 * @param product - Name of the product being scanned
	 * @param priceOneUnit - Price of the product per unit
	 * @param discountQuantity - The number of units to be bought to qualify for a discount (if applicable)
	 * @param discount - The discount offered in $ if discountQuantity units of product is bought (if applicable)
	 */

	public void setPrice(char product, double priceOneUnit, int discountQuantity, double discount) {
		Product p = new Product(product,priceOneUnit,discountQuantity,discount);
		productInfo.put(product, p);

	}

	/**
	 * This function is called when a product is scanned at the terminal. Two things happen:
	 * 1. Update the product count hash map
	 * 2. Calculate the price of the current scanned product (just like on the terminal, when you scan,
	 * you see the price on scan and gets added to the system
	 * @param c - product name 
	 */

	public void scan(char c) {
		int occurence = updateProductCount(c);
		calculatePrice(c,occurence);
	}

	/**
	 * This function just adds the prices of all the products scanned 
	 * @return - The final amount for all the products (including discount)
	 */

	public double total() {
		for(double x: productCost.values()){
			total = total + x;

		}
		return total;
	}

}
