package com.project;

import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.project.dtos.ProductReturnDto;
import com.project.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoeProjectDemoApplicationTests {
	@LocalServerPort
	private int port;

	RestTemplate restTemplate = new RestTemplate();

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void testGetAllProducts() {
		ResponseEntity<Product[]> responseEntity = restTemplate.getForEntity(getRootUrl() + "/listProducts", Product[].class);
		List<Product> products = Arrays.asList(responseEntity.getBody());
		assertNotNull(products);
	}
	
	@Test
	public void testGetAllDetail() {
		ResponseEntity<ProductReturnDto[]> responseEntity = restTemplate.getForEntity(getRootUrl() + "/listDetails", ProductReturnDto[].class);
		List<ProductReturnDto> productDetails = Arrays.asList(responseEntity.getBody());
		assertNotNull(productDetails);
	}
	
}
