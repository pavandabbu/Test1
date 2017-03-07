package com.assessment.bean;

/**
 * OrderLine class - represents an order line which contains the {@link Item} and the quantity.
 *
 */
public class OrderLine {

	private int quantity;
	private Item item;

	/**
	 * Create an OrderLine
	 * 
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	public OrderLine(Item item, int quantity) throws Exception {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		this.item = item;
		this.quantity = quantity;
	}

	/**
	 * get Item for this Order Line
	 *
	 * @return item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * get quantity for this Order Line
	 *
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}
}