package com.product.service;

import java.util.List;
import java.util.Optional;

import com.product.entity.ProdCategary;
import com.product.entity.Product;
import com.product.entity.ProductResponce;


public interface ProdService {
public   Product  save(Product product);
public  List<Product> getProducts();
List<ProdCategary> getProductCategaryList();
Optional<Product> getProductById(int productId);

Optional<ProdCategary> get(String cat);
ProductResponce getProduct(int pid);
ProdCategary savecat(ProdCategary prodCategary);
Product updateProduct(Product product, Integer pid);

String deleteProduct(Integer pid);
List<ProductResponce> getAllProList();

    
}
