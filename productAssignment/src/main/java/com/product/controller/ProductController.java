package com.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.ProdCategary;
import com.product.entity.Product;
import com.product.entity.ProductResponce;

import com.product.service.ProdService;

@RestController
public class ProductController {
	@Autowired
	ProdService prodService;

	
	
	 
	// add Product categary details
	@PostMapping("/addProductCategary")
	public ProdCategary addcategary(@RequestBody ProdCategary prodCategary) {
		return prodService.savecat(prodCategary);

	}
	
	@GetMapping("/fetchAllCategary")
	public List<ProductResponce> get() {
		return prodService.getAllProList();

	}

//    //Fetch All Products Categaries
//	@GetMapping("/fetchAllCategary")
//	public List<ProdCategary> getProductCategaryList() {
//		return prodService.getProductCategaryList();
//
//	}

	// add product
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return prodService.save(product);

	}

	// Fetch All Products
	@GetMapping("/fetchAllProducts")
	public List<Product> getProductList() {
		return prodService.getProducts();

	}

	// getProducts method will calculate the final price of each product based on
	// discount and other charges table .
	@GetMapping("/getProducts/{pid}")
	public ProductResponce getProductDetails(@PathVariable("pid") int pid) {
		return prodService.getProduct(pid);

	}

	// update product
	@PutMapping("/update/{pid}")
	public Product updateProduct(@RequestBody Product product, @PathVariable("pid") Integer pid) {
		return prodService.updateProduct(product, pid);

	}

	// delete product
	@DeleteMapping("/delete/{pid}")
	public String deleteProduct(@PathVariable("pid") Integer pid) {
		return prodService.deleteProduct(pid);

	}

//     @GetMapping("/getProductById/{pid}")
//     public Optional<Product> getProductById( @PathVariable("pid") Integer productId) {
//		return prodService.getProductById(productId);
//    	 
//     }
//     @GetMapping("/getCatgaryById/{cat}")
//     public Optional<ProdCategary> getProductById( @PathVariable("cat") String cat) {
//		return prodService.get(cat);
//    	 
//     }
}
