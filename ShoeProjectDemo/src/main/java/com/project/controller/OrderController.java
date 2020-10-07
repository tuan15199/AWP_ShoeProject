package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dtos.OrderDto;
import com.project.dtos.OrderReturn;
import com.project.dtos.TopCustomersDto;
import com.project.model.OrderStatus;
import com.project.model.Orders;
import com.project.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService service;

	@GetMapping(value = "orders")
	public List<Orders> getAll() {
		return service.getAll();
	}
	
	@GetMapping(value = "order/{id}")
	public Orders getOrderById(@PathVariable Integer id) {
		return service.getOrderById(id);
	}

	@GetMapping(value = "ordersByTime")
	public List<Orders> getOrderByTime(@RequestParam String fromDate, @RequestParam String toDate) {
		return service.getOrderByRangeOfTime(fromDate, toDate);
	}

	@GetMapping(value = "ordersByDate")
	public List<Orders> getOrderByDate(@RequestParam String date) {
		return service.getOrderByDate(date);
	}
	
	@GetMapping(value = "ordersByTime/deliveried")
	public List<Orders> getOrderSuccessByTime(@RequestParam String fromDate, @RequestParam String toDate) {
		return service.getOrderSuccessByRangeOfTime(fromDate, toDate);
	}
	
	@GetMapping(value = "ordersByTimeAndStatus")
	public List<Orders> getOrderByTimeAndStatus(@RequestParam String fromDate, @RequestParam String toDate, @RequestParam int status) {
		return service.getOrderByTimeAndStatus(fromDate, toDate, status);
	}

	@GetMapping(value = "ordersByDate/deliveried")
	public List<Orders> getOrderSuccessByDate(@RequestParam String date) {
		return service.getOrderSuccessByDate(date);
	}
	
	@GetMapping(value = "ordersByDateAndStatus")
	public List<Orders> getOrderByDateAndStatus(@RequestParam String date, @RequestParam int status) {
		return service.getOrderByDateAndStatus(date, status);
	}
	
	@GetMapping(value = "ordersByStatus")
	public List<Orders> getOrderByStatus(@RequestParam int status) {
		return service.getOrderByStatus(status);
	}
	
	@GetMapping(value = "ordersSuccess")
	public List<Orders> getDeliveriedOrder() {
		return service.getDeliveriedOrder();
	}

	@GetMapping(value = "orderDetails/{id}")
	public List<OrderReturn> getOrderDetailByOrderId(@PathVariable Integer id) {
		return service.getOrderDetailByOrderId(id);
	}

	@PostMapping(value = "order")
	public Orders createOrder(@RequestBody OrderDto order) {
		return service.createOrder(order);
	}

	@PutMapping(value = "orderVerified/{id}")
	public Orders updateVerified(@PathVariable Integer id) {
		return service.orderVerified(id);
	}

	@PutMapping(value = "orderCancel/{id}")
	public Orders updateCancel(@PathVariable Integer id) {
		return service.orderCancel(id);
	}

	@PutMapping(value = "orderDeliveried/{id}")
	public Orders updateDeliveried(@PathVariable Integer id) {
		return service.orderDeliveried(id);
	}
	
	@GetMapping(value = "topCustomers")
	public List<TopCustomersDto> findTopCustomers(@RequestParam int top){
		return service.getTopCustomers(top);
	}
}
