package com.roberto.iosys.entity;

public class Item {
	
	private Long id;
	private String descriptionItem;
	private Double price;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescriptionItem() {
		return descriptionItem;
	}
	public void setDescriptionItem(String descriptionItem) {
		this.descriptionItem = descriptionItem;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
