package com.chiplua.factorymode;
import com.chiplua.factorymode.Product;

public class ProductCreator{
	public Product creatorProduct(String type) {
		if ("Fan".equals(type)) {
			return new ProductFan();
		} else if ("Mouse".equals(type)) {
			return new ProductMouse();
		} else {
			return null;
		}
	}
}
