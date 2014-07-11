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
