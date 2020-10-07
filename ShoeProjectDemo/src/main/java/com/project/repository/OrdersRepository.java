package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.dtos.OrderReturn;
import com.project.dtos.TopCustomersDto;
import com.project.model.OrderStatus;
import com.project.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer>{

	@Query("SELECT new com.project.dtos.OrderReturn(od.id, o.firstName, o.lastName, o.orderDate, o.deliveryDate, p.name, od.quantity, od.totalPrice) FROM Orders o JOIN o.orderDetail od "
			+ "JOIN od.product pd JOIN pd.product p WHERE o.id = :id")
	List<OrderReturn> getOrderDetailByOrderId(Integer id);
	
	@Query(value = "SELECT * FROM orders WHERE order_date between :fromDate and :toDate", nativeQuery = true)
	List<Orders> getOrderByTime(String fromDate, String toDate);
	
	@Query(value = "SELECT * FROM orders WHERE order_date LIKE :date%", nativeQuery = true)
	List<Orders> getOrderByDate(String date);
	
	@Query(value = "SELECT * FROM orders WHERE order_date between :fromDate and :toDate and status = 3", nativeQuery = true)
	List<Orders> getOrderSuccessByTime(String fromDate, String toDate);
	
	@Query(value = "SELECT * FROM orders WHERE order_date between :fromDate and :toDate and status = :status", nativeQuery = true)
	List<Orders> getOrderByTimeAndStatus(String fromDate, String toDate, int status);
	
	@Query(value = "SELECT * FROM orders WHERE order_date LIKE :date% and status = 3", nativeQuery = true)
	List<Orders> getOrderSuccessByDate(String date);
	
	@Query(value = "SELECT * FROM orders WHERE order_date LIKE :date% and status = :status", nativeQuery = true)
	List<Orders> getOrderByDateAndStatus(String date, int status);
	
	@Query(value = "SELECT * FROM orders WHERE status = 3", nativeQuery = true)
	List<Orders> getDeliveriedOrder();
	
	@Query(value = "SELECT * FROM orders WHERE status = :status", nativeQuery = true)
	List<Orders> getOrderByStatus(int status);
	
//	@Query(value = "SELECT first_name, last_name, phone, email, sum(total_price) FROM shoeappdemo.orders WHERE status = 3 GROUP BY first_name, last_name, phone, email ORDER BY sum(total_price) desc LIMIT 2", nativeQuery = true)
//	List<Object> getTopCustomers(int top);
	
	@Query(value = "SELECT phone, sum(total_price) FROM shoeappdemo.orders WHERE status = 3 GROUP BY phone ORDER BY sum(total_price) desc LIMIT :top", nativeQuery = true)
	List<String> getTopPhone(int top);
	
	List<Orders> findByPhone(String phone);
}
