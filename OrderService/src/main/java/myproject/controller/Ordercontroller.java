package myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.model.Order;
import myproject.service.Orderservice;


@RestController
@RequestMapping("/order")
public class Ordercontroller {
	@Autowired
	Orderservice orderservice;



	@PostMapping("/post")
	public ResponseEntity<String> placeoreders(@RequestBody Order order)
	{
		return  orderservice.placeorder(order);
	}



}
