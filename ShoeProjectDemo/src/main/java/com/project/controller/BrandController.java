package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.ObjectReturn;
import com.project.model.Brand;
import com.project.service.BrandService;

@RestController
public class BrandController {
	@Autowired
	private BrandService service;

	@GetMapping(value = "/brands")
	public ObjectReturn<Brand> getAll() {
		return service.getAll();
	}

//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/brand", consumes = "application/json")
	public Brand createBrand(@RequestBody Brand brand) {
		return service.createBrand(brand);
	}

}
