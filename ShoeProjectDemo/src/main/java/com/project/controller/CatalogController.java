package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.ObjectReturn;
import com.project.model.Catalog;
import com.project.service.CatalogService;

@RestController
public class CatalogController {
	@Autowired
	private CatalogService service;
	
	@GetMapping(value = "listCatalogs")
	public List<Catalog> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "catalogs")
	public ObjectReturn<Catalog> getAllCatalogs() {
		return service.getAllCatalog();
	}
	
	@PostMapping(value = "catalog", consumes = "application/json")
	public Catalog createCatalog(@RequestBody Catalog catalog) {
		return service.createCatalog(catalog);
	}
}
