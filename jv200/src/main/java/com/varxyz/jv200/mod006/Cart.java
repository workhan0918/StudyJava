package com.varxyz.jv200.mod006;

public class Cart {
	private Product[] products = new Product[3];
	
	public void addProduct (Product p) {
		for (int i = 0; i < products.length; i++) {
			if(products[i] == null) {
				products[i] = p;
				break;
			}
		}
	}
	
	public Product[] getProducts() {
		return products;
	}
	
	public String getDetails() {
		String str = null;
		for(Product p : products) {
			str = "Name: " + p.getName() + "\nPrice: " + p.getPrice();
			if (p instanceof SmartPhone) {
				SmartPhone s = (SmartPhone) p;
				str += "\nPlatform: " + s.getPlatform();
			}
		}
		return str;
	}
}