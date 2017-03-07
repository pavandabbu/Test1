package com.assessment;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.assessment.bean.Item;
import com.assessment.bean.OrderLine;
import com.assessment.service.IOrderService;
import com.assessment.service.Order;
import com.assessment.util.Calculator;

/**
 * 
 * Test class for Calculator
 *
 */
public class CalculatorTest {

	Calculator calculator;

	@Before
	public void setUp() {
		calculator = new Calculator();
	}

	/**
	 * 
	 * Test case for rounding method
	 *
	 */
	@Test
	public void testRounding() {
		Assert.assertEquals(136.28, Calculator.rounding(136.278), 0.001);
		Assert.assertEquals(192.92, Calculator.rounding(192.923), 0.001);
	}

	/**
	 * 
	 * Test case for calculate method
	 *
	 */
	@Test
	public void testCalculator() throws Exception {

		Map<String, IOrderService> orderMap = new LinkedHashMap<String, IOrderService>();

		Order c = new Order();

		// Add OrderLines to the Order
		c.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		// Add order to the map
		orderMap.put("Order 1", c);

		// Create a new Order
		c = new Order();
		// Add OrderLines to the Order
		c.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		// Add order to the map
		orderMap.put("Order 2", c);

		// Create a new Order
		c = new Order();
		// Add OrderLines to the Order
		c.add(new OrderLine(new Item("imported bottle of perfume", (float) 27.99), 1));
		c.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c.add(new OrderLine(new Item("box of imported chocolates", (float) 11.25), 1));

		// Add order to the map
		orderMap.put("Order 3", c);

		double total = calculator.calculate(orderMap);
		Assert.assertEquals(153.81, total, 0.01);

	}
}