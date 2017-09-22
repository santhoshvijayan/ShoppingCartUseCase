package com.santhosh.shopping.repositories;

import java.awt.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.shopping.models.Order;
import com.santhosh.shopping.models.User;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
	public List findByUserid(String userid);
//	public Order findByCatr_id(String id);
	
}