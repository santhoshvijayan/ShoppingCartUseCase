package com.santhosh.shopping.models;

import java.util.Arrays;
import java.util.Date;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carts")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class Cart {
	@Id
	private String _id;
	private int total;
	@JsonProperty("items")
	private CartItem[] items;
	private int itemsCount;
	
	




	public String get_id() {
		return _id;
	}



	public void set_id(String _id) {
		this._id = _id;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public CartItem[] getItems() {
		return items;
	}



	public void setItems(CartItem[] items) {
		this.items = items;
	}



	public int getItemsCount() {
		return itemsCount;
	}



	public void setItemsCount(int itemsCount) {
		this.itemsCount = itemsCount;
	}



	@Override
	public String toString() {
		return "Cart [_id=" + _id + ", total=" + total + ", items=" + Arrays.toString(items) + ", itemsCount="
				+ itemsCount + "]";
	}
	
	
	
}