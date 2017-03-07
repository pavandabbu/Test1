package com.assessment.service;

import com.assessment.bean.OrderLine;

public interface IOrderService {

	/**
	 * Add an Order Line
	 * 
	 * @param orderLine
	 * @throws IllegalArgumentException
	 */
	void add(OrderLine orderLine) throws IllegalArgumentException;

	/**
	 * Total elements in the order
	 * 
	 * @return
	 */
	int size();

	/**
	 * Get an order at given index position
	 * 
	 * @param index
	 * @return OrderLine
	 */
	OrderLine get(int index);

	/**
	 * Clear the cart
	 */
	void clear();

}
