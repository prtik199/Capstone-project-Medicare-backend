

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Product;
import com.example.demo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public Product addProduct(Product p) {
		return repo.save(p);
	}
	public List<Product> getAllProduct(){
		return repo.findAll();
	}
	public Product getProductById(int id) {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}
		else {
			return null;
		}
		
	}
	public Product updateProduct(int id, Product newProduct) {
		if(repo.findById(id).isPresent()) {
			Product oldProduct= repo.findById(id).get();
			oldProduct.setName(newProduct.getName());
			oldProduct.setDescription(newProduct.getDescription());
			oldProduct.setPrice(newProduct.getPrice());
			
			return repo.save(oldProduct);
		}
		else {
			return null;
		}
	}
	
	
	public boolean deleteProduct(int id) {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
			return true;
		}
		
		else {
			return false;
		}
	}
	
	

}