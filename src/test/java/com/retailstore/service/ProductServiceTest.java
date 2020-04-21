package com.retailstore.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailstore.dataaccesslayer.entity.Product;
import com.retailstore.rest.controller.CustomException;
import com.retailstore.rest.controller.product.beans.ProductInfo;
import com.retailstore.service.ProductService;
import com.retailstore.util.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testProductCreate(){
		Product p1 = productService.createProduct(new ProductInfo("ORS-BBB-0001", 20.0, "Tomato", ProductCategory.A));
		Product p2 = productService.getProductById(p1.getId());
		assertThat(p1.getId()).isEqualTo(p2.getId());
	}

	@Test
	public void testProductUpdate(){
		Product p1 = productService.createProduct(new ProductInfo("ORS-CCC-0001", 20.0, "Tomato", ProductCategory.A));
		Product p2 = productService.updateProduct(new ProductInfo("ORS-CCC-0002", 30.0, "Potato", ProductCategory.B),p1.getId());
		Product p3 = productService.getProductById(p1.getId());
		assertThat(p3.getId()).isEqualTo(p2.getId());
		
		assertThat(p3.getBarCodeId()).isEqualTo(p2.getBarCodeId());
		assertThat(p3.getRate()).isEqualTo(p2.getRate());
		assertThat(p3.getProductCategory()).isEqualTo(p2.getProductCategory());
	}

	@Test(expected=CustomException.class)
	public void testProductUpdateForNonExistingProduct(){
		productService.createProduct(new ProductInfo("ORS-DDD-0001", 20.0, "Tomato", ProductCategory.A));
		productService.updateProduct(new ProductInfo("ORS-DDD-0002", 30.0, "Potato", ProductCategory.B),(long)99999); 
	}
	
	
	@Test(expected=CustomException.class)
	public void testProductDelete(){
		Product p1 = productService.createProduct(new ProductInfo("ORS-EEE-0001", 20.0, "Tomato", ProductCategory.A));
		productService.deleteProduct(p1.getId());
		Product p3 = productService.getProductById(p1.getId());
		assertThat(p3).isNull();
	}
	
	@Test(expected=CustomException.class)
	public void testDelete(){
		productService.deleteProduct((long)1);
		Product p3 = productService.getProductById((long)1);
		assertThat(p3).isNull();
	}

	

}
