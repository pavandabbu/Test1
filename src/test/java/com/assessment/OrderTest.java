package com.assessment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.assessment.bean.Item;
import com.assessment.bean.OrderLine;
import com.assessment.service.Order;

/**
 * 
 * Unit Test Order class
 *
 */
public class OrderTest {

	private Order order;

	@Before
	public void setUp() {
		order = new Order();
	}

	/**
	 * 
	 * Test the add method
	 *
	 */
	@Test
	public void testAdd() throws Exception {
		// Add 3 OrderLines to the Order
		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		// Check the order size
		Assert.assertEquals(3, order.size());
		Assert.assertFalse(order.size() < 0);

		// Check the Item names
		Assert.assertEquals("book", order.get(0).getItem().getDescription());
		Assert.assertEquals("music CD", order.get(1).getItem().getDescription());
		Assert.assertEquals("chocolate bar", order.get(2).getItem().getDescription());

		// Check the Item price
		Assert.assertEquals(12.49, order.get(0).getItem().getPrice(), 0.001);
		Assert.assertEquals(14.99, order.get(1).getItem().getPrice(), 0.001);
		Assert.assertEquals(0.85, order.get(2).getItem().getPrice(), 0.001);

		// Check the order quantity
		Assert.assertEquals(1, order.get(0).getQuantity());
		Assert.assertEquals(1, order.get(1).getQuantity());
		Assert.assertEquals(1, order.get(2).getQuantity());
	}

	/**
	 * 
	 * Test add method by passing null OrderLine
	 *
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddWithNull() {
		// Add null to the Order
		order.add(null);
	}

	/**
	 * 
	 * Test the size method
	 *
	 */
	@Test
	public void testSize() throws Exception {
		// Check the order size
		Assert.assertEquals(0, order.size());

		// Add 3 OrderLines to the Order
		order.add(new OrderLine(new Item("book", (float) 12.49), 1));
		order.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		order.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		// Check the order size
		Assert.assertEquals(3, order.size());

		// Clear orders
		order.clear();

		// Check the order size
		Assert.assertEquals(0, order.size());
	}

	/**
	 * 
	 * Test the get method
	 *
	 */
	@Test
	public void testGet() throws Exception {
		OrderLine orderLine1 = new OrderLine(new Item("book", (float) 12.49), 1);
		OrderLine orderLine2 = new OrderLine(new Item("music CD", (float) 14.99), 1);
		OrderLine orderLine3 = new OrderLine(new Item("chocolate bar", (float) 0.85), 1);
		// Add 3 OrderLines to the Order
		order.add(orderLine1);
		order.add(orderLine2);
		order.add(orderLine3);

		// Check the order size
		Assert.assertEquals(3, order.size());

		// Check the Item names
		Assert.assertEquals(orderLine1, order.get(0));
		Assert.assertEquals(orderLine2, order.get(1));
		Assert.assertEquals(orderLine3, order.get(2));
	}
}