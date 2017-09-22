package com.santhosh.shopping.models;

import java.util.Arrays;
import java.util.Date;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "items")
@JsonIgnoreProperties(value = { "createdAt" }, allowGetters = true)
public class Items {

	String title;
	String description;
	String category;
	double price;
	String[] images;
	int mainImageIndex;
	int qty;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getImages() {
		return images;
	}

	public void setImages(String[] images) {
		this.images = images;
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
		return "Items [title=" + title + ", description=" + description + ", category=" + category + ", price=" + price
				+ ", images=" + Arrays.toString(images) + ", mainImageIndex=" + mainImageIndex + ", qty=" + qty + "]";
	}

}