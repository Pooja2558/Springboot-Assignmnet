package com.product.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.entity.ProdCategary;

public interface CatRepo  extends JpaRepository<ProdCategary, String>{
	
	//find by cat name
	@Query("select p from ProdCategary p where p.category =:category")
	public Optional<ProdCategary> getListCatName(@Param("category") String category);

}
