
package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Product;
import com.example.demo.ProductService;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/Product")
public class ProductConroller {
	
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/")
	public ResponseEntity<Product> addProduct(@RequestBody Product p){
		
		Product Product= service.addProduct(p);
		
		if(Product!=null)
			return new ResponseEntity<Product>(Product,HttpStatus.CREATED);
		else
			return new ResponseEntity<Product>(Product,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	@GetMapping("/")
	public List<Product> getAllProduct(){
		return service.getAllProduct();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product>getProductById (@PathVariable int id){
		Product Product= service.getProductById(id);
		
		if(Product!=null)
			return new ResponseEntity<Product>(Product, HttpStatus.FOUND);
		else
			return new ResponseEntity<Product>(Product, HttpStatus.NOT_FOUND);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id,@RequestBody Product newProduct){
		Product Product= service.updateProduct(id, newProduct);
		
		if (Product!=null)
			return new ResponseEntity<Object>(Product,HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Product Available to Update",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteProduct(@PathVariable int id){
		boolean result = service.deleteProduct(id);
		if(result) 
			return new ResponseEntity<String>("Object Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("NO Product Found", HttpStatus.NOT_FOUND);
		
	}
 
}

