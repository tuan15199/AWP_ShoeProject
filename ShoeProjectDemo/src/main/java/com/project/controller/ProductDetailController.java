package com.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.ProductDetailDto;
import com.project.dtos.ProductReturnDto;
import com.project.model.ProductDetail;
import com.project.service.ProductDetailService;

@RestController
public class ProductDetailController {
	@Autowired
	private ProductDetailService service;
	
	private Logger logger = LoggerFactory.getLogger(ProductDetailController.class);
	
	@GetMapping(value = "productDetails")
	public List<ProductDetail> getAll() {
		logger.info("Show all product details!");
		return service.getAll();
	}
	
	@PostMapping(value = "productDetail", consumes = "application/json")
	public ProductDetail createProDetail(@RequestBody ProductDetailDto productDetail) {
		logger.info("Create new product detail successfully!");
		return service.createProDetail(productDetail);
	}
	
	@PutMapping(value = "updateProductDetail")
	public ProductDetail updateProDetail(@RequestBody ProductReturnDto productDetail) {
		logger.info("Update product detail successfully!");
		return service.updateProductDetail(productDetail);
	}
}
