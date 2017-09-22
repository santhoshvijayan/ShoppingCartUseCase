package com.santhosh.shopping.models;

import java.util.Arrays;
import java.util.Date;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class CartItem {
	private String _id;
	private int total;
	private String[] image;
	private String title;
	private int price;
	private int mainImageIndex;
	private int qty;

	
	
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
	public String[] getImage() {
		return image;
	}
	public void setImage(String[] image) {
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMainImageIndex() {
		return mainImageIndex;
	}
	public void setMainImageIndex(int mainImageIndex) {
		this.mainImageIndex = mainImageIndex;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "CartItem [_id=" + _id + ", total=" + total + ", image=" + Arrays.toString(image) + ", title=" + title
				+ ", price=" + price + ", mainImageIndex=" + mainImageIndex + ", qty=" + qty + "]";
	}
	
	
	
	
}