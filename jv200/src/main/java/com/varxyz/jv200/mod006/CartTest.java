package com.varxyz.jv200.mod006;

public class CartTest {

	public static void main(String[] args) {
		Cart cart = new Cart();
		cart.addProduct(new NoteBook("thinkPad"));
		cart.addProduct(new SmartPhone("Samsung Galaxy"));
		cart.addProduct(new SmartPhone("Apple Iphone"));
		cart.addProduct(new Pad("Apple Ipad"));
		
		System.out.println(cart.getDetails());
	}

}
