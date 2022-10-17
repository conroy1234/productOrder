package com.product.order.productOrder.client;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.product.order.productOrder.dto.Order;
import com.product.order.productOrder.service.OrderService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnit38ClassRunner.class)
public class OrderControllerTest {
	private static final int MIN = 1;
	private static final int MAX = 1000;
	private static final int ID = (int) Math.floor(Math.random() * (MAX - MIN + 1) + MAX);
	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;

	@Test
	public void whenPlaceOrderForProduct() {
		int succesOrderCode = 201;
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(orderService.saveOrder(any(String.class))).thenReturn(saveOrder());
		Order order = new Order(ID, "DARK BRICK", 20.3, 34, "DF10");
		ResponseEntity<Order> responseEntity = orderController.saveOrder(order, "DF13");
		assertEquals(succesOrderCode, responseEntity.getStatusCodeValue());
		assertEquals(responseEntity.getHeaders().getLocation().getPath(), "/" + ID);
	}

	
	private Order saveOrder() {
		return new Order(ID, "DARK BRICK", 20.3, 34, "DF10");

	}

}
