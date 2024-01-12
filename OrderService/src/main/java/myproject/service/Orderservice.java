package myproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import myproject.model.Order;

@Transactional
public interface Orderservice {


	public ResponseEntity<String> placeorder(Order order);

	public List<Order> getallorders();

	public Order getorderbyid(Long id);
	public Order Updateorderbyid(Order order,Long id);
	public ResponseEntity<String>deleteorder(Long id);



}
