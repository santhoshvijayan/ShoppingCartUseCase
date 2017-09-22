package com.santhosh.shopping.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.santhosh.shopping.models.Todo;

@Repository
public interface TodoRepository extends MongoRepository<Todo, String> {

}