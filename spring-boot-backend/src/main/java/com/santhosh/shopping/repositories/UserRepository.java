package com.santhosh.shopping.repositories;

import java.awt.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.shopping.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}