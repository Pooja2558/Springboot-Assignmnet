package com.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.ProdCategary;
import com.product.entity.Product;
import com.product.entity.ProductResponce;

import com.product.entity.charges;
import com.product.repo.CatRepo;
import com.product.repo.ProductRepo;

@Service
public class ProdServiceImpl implements ProdService {

	@Autowired
	ProductRepo productRepo;

	@Autowired
	CatRepo catRepo;

	@Override
	public ProdCategary savecat(ProdCategary prodCategary) {
		return catRepo.save(prodCategary);
	}

	@Override
	public Product save(Product product) {
		return productRepo.save(product);
	}

	@Override
	public List<Product> getProducts() {

		return productRepo.findAll();
	}

	@Override
	public Optional<Product> getProductById(int productId) {
		return productRepo.findById(productId);
	}

	@Override
	public Optional<ProdCategary> get(String cat) {

		return catRepo.findById(cat);
	}

	@Override
	public ProductResponce getProduct(int pid) {
		Optional<Product> Product = productRepo.findById(pid);
		String category = Product.get().getCategory();
		Optional<ProdCategary> product_category = catRepo.getListCatName(category);

		// product price
		double basePrice = Product.get().getBasePrice();

		// calculate discount
		double dis = product_category.get().getDis();
		double s = 100 - dis;
		double totaldiscount = basePrice - (s * basePrice) / 100;

		// calculate Gst
		double gst = product_category.get().getGst();
		double totalGst = basePrice * (gst / 100);
		// calculate delivery charge
		double deliveryCharge = product_category.get().getDeliverycharge();

		// Final price is calculated excluding discounts and including GST and Delivery
		// Charges which are different for each product categories.
		double finalprice = basePrice - totaldiscount + deliveryCharge + totalGst;

		charges c = new charges();
		c.setGst(totalGst);
		c.setDeliverycharges(deliveryCharge);
		ProductResponce resp = new ProductResponce();
		Product p = Product.get();
		resp.setProductId(pid);
		resp.setName(p.getName());
		resp.setProductType(p.getProductType());
		resp.setCategory(p.getCategory());
		resp.setBaseprice(p.getBasePrice());
		resp.setDiscount(totaldiscount);
		resp.setCharges(c);
		resp.setFinalPrice(finalprice);
		return resp;
	}

	@Override
	public Product updateProduct(Product product, Integer pid) {
		Optional<Product> prod = productRepo.findById(pid);
		if (prod.isPresent()) {
			return productRepo.save(product);
		} else {
			return null;
		}
	}

	@Override
	public String deleteProduct(Integer pid) {
		Optional<Product> prod = productRepo.findById(pid);
		if (prod.isPresent()) {
			Product deleteprod = prod.get();
			productRepo.delete(deleteprod);
			return "succesfully delete";
		}
		return "please enter correct productid";
	}

	@Override
	public List<ProdCategary> getProductCategaryList() {

		return catRepo.findAll();
	}

	// get all products

	@Override
	public List<ProductResponce> getAllProList() {
		List<Product> prodList = productRepo.findAll();
		ProductResponce resp = new ProductResponce();
		List<ProductResponce> list = new ArrayList<ProductResponce>();
		for (Product p : prodList) {
			int pid = p.getProductId();
			Optional<Product> Product = productRepo.findById(pid);
			String category = Product.get().getCategory();
			Optional<ProdCategary> product_category = catRepo.getListCatName(category);

			// product price
			double basePrice = Product.get().getBasePrice();

			// calculate discount
			double dis = product_category.get().getDis();
			double s = 100 - dis;
			double totaldiscount = basePrice - (s * basePrice) / 100;

			// calculate Gst
			double gst = product_category.get().getGst();
			double totalGst = (basePrice * (gst / 100));
			// calculate delivery charge
			double deliveryCharge = product_category.get().getDeliverycharge();

			// Final price is calculated excluding discounts and including GST and Delivery
			// Charges which are different for each product categories.
			double finalprice = basePrice - totaldiscount + deliveryCharge + totalGst;

			charges c = new charges();
			c.setGst(totalGst);
			c.setDeliverycharges(deliveryCharge);

			resp.setProductId(pid);
			resp.setName(p.getName());
			resp.setProductType(p.getProductType());
			resp.setCategory(p.getCategory());
			resp.setBaseprice(p.getBasePrice());
			resp.setDiscount(totaldiscount);
			resp.setCharges(c);
			resp.setFinalPrice(finalprice);

			list.add(resp);
		}

		return list;

	}

}
