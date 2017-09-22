package com.santhosh.shopping.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.santhosh.shopping.SpringMongoConfig;
import com.santhosh.shopping.models.Cart;
import com.santhosh.shopping.models.Items;
import com.santhosh.shopping.models.Order;
import com.santhosh.shopping.models.User;
import com.santhosh.shopping.repositories.CartRepository;
import com.santhosh.shopping.repositories.ItemsRepository;
import com.santhosh.shopping.repositories.OrderRepository;
import com.santhosh.shopping.repositories.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SanthoshCartController {

	ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ItemsRepository itemsRepository;
	@Autowired
	CartRepository cartRepository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return userRepository.findAll(sortByCreatedAtDesc);
	}

	@GetMapping("/get-orders")
	public List<Order> getAllOrders() {
		System.out.println("");
		Sort sortByCreatedAtDesc = new Sort(Sort.Direction.DESC, "createdAt");
		return orderRepository.findAll(sortByCreatedAtDesc);
	}

	@GetMapping("/get-user-orders/{id}")
	public String getOrderByUser(@PathVariable("id") String id) {
		Query query3 = new Query();
		query3.addCriteria(Criteria.where("userid").is(id));
		List<Order> OrderList = (ArrayList<Order>) mongoOperation.find(query3, Order.class);
		System.out.println("query3 - " + query3.toString());
		return new Gson().toJson(OrderList);
	}

	@PostMapping("/checkout")
	public Order createOrder(@Valid @RequestBody Order order) {
		order.setDate(new Date());
		Order retOrder = orderRepository.save(order);
		retOrder.setCart(null);
		return retOrder;
	}

	@GetMapping("/items")
	public List<Items> getAllItems() {
		List<Items> items = itemsRepository.findAll();
		if (items == null) {
			return null;
		} else {
			return items;
		}
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User user = userRepository.findOne(id);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	@GetMapping("/items/{id}")
	public ResponseEntity<Items> getItemsById(@PathVariable("id") String id) {
		Items items = itemsRepository.findOne(id);
		if (items == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(items, HttpStatus.OK);
		}
	}

	@GetMapping("/carts/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable("id") String id) {
		Cart cart = cartRepository.findOne(id);
		if (cart == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(cart, HttpStatus.OK);
		}
	}

	// @PutMapping(value="/users/change-image/{id}")
	// public ResponseEntity<User> updateUserImage(@PathVariable("id") String id,
	// @Valid @RequestBody User user) {
	//// user = userRepository.findOne(id);
	// if(user == null) {
	// return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	// }
	// User updatedUser = userRepository.save(user);
	// return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	// }

	@PutMapping(value = "/users/update-info")
	public ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User updatedUser = userRepository.save(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
}