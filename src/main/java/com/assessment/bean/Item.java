package com.assessment.bean;

/**
 * Item class - represents an item, contains a price and a description.
 */
public class Item {

	private String description;
	private float price;

	/**
	 * Constructs an Item
	 * 
	 * @param description - Item Description
	 * @param price - Item Price
	 */
	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	/**
	 * get item description
	 *
	 * @return item description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * get item price
	 *
	 * @return item price
	 */
	public float getPrice() {
		return price;
	}
}