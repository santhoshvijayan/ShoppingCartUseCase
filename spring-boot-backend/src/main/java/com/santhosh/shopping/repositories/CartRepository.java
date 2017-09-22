package com.santhosh.shopping.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.shopping.models.Cart;
import com.santhosh.shopping.models.Order;
import com.santhosh.shopping.models.User;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

}