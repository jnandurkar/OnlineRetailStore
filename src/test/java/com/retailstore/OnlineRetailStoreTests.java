package com.retailstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailstore.dataaccesslayer.entity.Product;
import com.retailstore.dataaccesslayer.repository.ProductRepository;
import com.retailstore.util.ProductCategory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineRetailStoreTests {

	@Autowired
	private ProductRepository productMasterRepo;

	@Test
	public void contextLoads() {
	}

	public void testProductSetup() {
		productMasterRepo.save(new Product("ORS-1234", 20.0, "Tomato", ProductCategory.A));
		productMasterRepo.save(new Product("ORS-1235", 40.0, "Onion", ProductCategory.B));
		productMasterRepo.save(new Product("ORS-1236", 50.0, "Potato", ProductCategory.C));
		productMasterRepo.save(new Product("ORS-1237", 35.0, "Bread", ProductCategory.A));
		productMasterRepo.save(new Product("ORS-1238", 100.0, "Apples", ProductCategory.B));
		productMasterRepo.save(new Product("ORS-1239", 49.0, "Banana", ProductCategory.C));
		assertThat(productMasterRepo.count()).isEqualTo(6);
	}

}
