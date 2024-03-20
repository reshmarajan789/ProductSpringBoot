package com.project.Product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.Product.exception.productNotFoundException;
import com.project.Product.model.product;
import com.project.Product.repository.productRepository;
import com.project.Product.service.productService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/product/")
public class productController {
	
	
	@Autowired
	private productService productservice;
	
	@Autowired
	private  productRepository productrepository;

	@GetMapping("/getProductDetails") // fetch all details
	public ResponseEntity<List<product>> getProductDetails() {

		try {
			List<product> productList = new ArrayList<product>();
			productservice.getAllProductDetails().forEach(productList::add);
			if (productList.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			else
				return new ResponseEntity<>(productList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<product>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/{id}") // fetch only 1 value
	public ResponseEntity<product> getProductById(@PathVariable("id") int id) throws productNotFoundException {

		return ResponseEntity.ok(productservice.getproductDetailsById(id));

	}
		
	@PostMapping("/updateproduct/{id}")//update
		public ResponseEntity<product> updateProductById(@PathVariable("id") int id,@RequestParam product newProduct) throws productNotFoundException {
	Optional<product> product=productrepository.findById(id);
	if (!product.isEmpty()) {
		product nnnewproduct=product.get();
		nnnewproduct.setName(newProduct.getName());
		product updateobj=productrepository.save(nnnewproduct);
		return new ResponseEntity<product>(updateobj,HttpStatus.OK);
	}
	return new ResponseEntity<product>(HttpStatus.NOT_FOUND);
		
		}
		
		@DeleteMapping("/deleteProduct/{id}") // deletion
		public ResponseEntity<product> deleteProduct(@PathVariable("id") int id) {
			productrepository.deleteById(id);
			return new ResponseEntity<product>(HttpStatus.OK);

		}
		@PostMapping("/save")//to addd/save
		public ResponseEntity<product> addProduct(@RequestBody @Valid product product) {
			product pr=productrepository.save(product);
			
			return new ResponseEntity<product>(pr,HttpStatus.CREATED);
		}
		}
		


