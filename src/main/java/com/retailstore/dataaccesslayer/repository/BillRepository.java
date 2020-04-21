package com.retailstore.dataaccesslayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.retailstore.dataaccesslayer.entity.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {

}
