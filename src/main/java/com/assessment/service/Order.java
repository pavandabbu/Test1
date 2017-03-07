package com.assessment.service;

import java.util.ArrayList;
import java.util.List;

import com.assessment.bean.OrderLine;

/**
 * Order class containing collection of {@link OrderLine} elements
 *
 */
public class Order implements IOrderService {

	private List<OrderLine> orderLines = new ArrayList<OrderLine>();

	/**
	 * Add an OrderLine to the cart
	 * 
	 * @param orderLine
	 * @throws IllegalArgumentException if the specified orderLine is null
	 */
	public void add(OrderLine orderLine) throws IllegalArgumentException {
		// Throw an exception if the item is null
		if (orderLine == null) {
			System.out.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		orderLines.add(orderLine);
	}

	/**
	 * Number of items in the cart
	 * 
	 * @return
	 */
	public int size() {
		return orderLines.size();
	}

	/**
	 * Get the {@link OrderLine} from collection at the given index position
	 * 
	 */
	public OrderLine get(int idx) {
		return orderLines.get(idx);
	}

	/**
	 * Clear the cart
	 * 
	 */
	public void clear() {
		this.orderLines.clear();
	}
}