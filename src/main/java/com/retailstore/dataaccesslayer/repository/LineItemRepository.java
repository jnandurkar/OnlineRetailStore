package com.retailstore.dataaccesslayer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.retailstore.dataaccesslayer.entity.LineItem;

public interface LineItemRepository extends CrudRepository<LineItem, Long> {
	
	public List<LineItem> findByProduct_id(long prodId);

}
