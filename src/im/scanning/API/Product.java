package im.scanning.API;

/**
 * This class handles the properties/behaviors of the Products 
 * @author Sannidhi
 *
 */
public class Product {

	private char name;
	private double discount,discountQuantity,pricePerUnit;

	public Product(char c, double pricePerUnit, int discountQuantity, double discount) {
		this.setName(c);
		this.setPriceOneUnit(pricePerUnit);
		this.setDiscountQuantity(discountQuantity);
		this.setDiscount(discount);
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getDiscountQuantity() {
		return discountQuantity;
	}

	public void setDiscountQuantity(double discountQuantity) {
		this.discountQuantity = discountQuantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPriceOneUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
