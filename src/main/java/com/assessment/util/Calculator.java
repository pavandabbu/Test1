package com.assessment.util;

import java.text.DecimalFormat;
import java.util.Map;

import com.assessment.service.IOrderService;

/**
 * Calculator class - calculates the grand total amount and tax
 *
 */
public class Calculator {
	/**
	 * round up to 2 decimal places
	 * 
	 * @param value input data
	 * @return rounder value
	 */
	public static double rounding(double value) {
		return new Double(new DecimalFormat("#.00").format(value));
	}

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 *
	 * @return Grand total
	 */
	public double calculate(Map<String, IOrderService> orderMap) {

		double grandtotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, IOrderService> entry : orderMap.entrySet()) {
			System.out.println("*******" + entry.getKey() + "*******");
			// Get an order from map
			IOrderService order = entry.getValue();

			double totalTax = 0;
			double total = 0;

			// Iterate through the items in the order
			for (int i = 0; i < order.size(); i++) {

				// Calculate the taxes
				double tax = 0;

				// Check if the item is an imported item and calculate tax accordingly
				if (order.get(i).getItem().getDescription().contains("imported")) {
					tax = rounding(order.get(i).getItem().getPrice() * 0.15); // Extra 5% tax on imported items
				} else {
					tax = rounding(order.get(i).getItem().getPrice() * 0.10);
				}

				// Calculate the total price
				double totalprice = order.get(i).getItem().getPrice() + tax;

				// Print out the item's total price
				System.out.println(order.get(i).getQuantity() + " " + order.get(i).getItem().getDescription() + ": " + rounding(totalprice));

				// Keep a running total tax
				totalTax += tax;
				// Keep a running total
				total += order.get(i).getItem().getPrice();
			}

			// Print out the total taxes
			System.out.println("Sales Tax: " + rounding(totalTax));

			// Print out the total amount
			System.out.println("Total: " + rounding(total));
			grandtotal += total;
		}
		// Print total amount for all the orders
		System.out.println("Sum of orders: " + rounding(grandtotal));
		return rounding(grandtotal);
	}
}