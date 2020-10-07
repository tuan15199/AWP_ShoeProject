package com.project.dtos;

import com.project.model.Type;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
	private Integer id;
	private String name;
	private Type type;
	private double price;
	private String brand;
	private int catalogId;
	private int brandId;
	
	public ProductDto(Integer id, String name, Type type, double price, String brand,
			int catalogId, int brandId) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.catalogId = catalogId;
		this.brandId = brandId;
		this.brand = brand;
	}

}