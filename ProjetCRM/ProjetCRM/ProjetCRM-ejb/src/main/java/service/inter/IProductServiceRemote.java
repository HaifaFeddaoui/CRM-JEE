package interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Product;
import entities.Stooore;

@Remote
public interface IProductServiceRemote {
	public List<Product> getAllProducts();
	//public List<Product> getProduct();
	public Product getProductById(int productId);
	public void updateProduct(Product product);
	//public Product getProductDetails(int productId);


	
	

}
