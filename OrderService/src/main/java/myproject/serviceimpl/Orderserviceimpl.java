package myproject.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import myproject.model.Order;
import myproject.model.Orderlineitems;
import myproject.repo.Orderrepo;
import myproject.service.Orderservice;

@Service
public class Orderserviceimpl  implements Orderservice{

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	Orderrepo orderrepo;



	@Override
	public ResponseEntity<String> placeorder(Order order) {
		List<Orderlineitems> orderLineItems = order.getOrderLineItems();
		String skuCode = orderLineItems.get(0).getSkucode();
		Integer quantity = orderLineItems.get(0).getQuantity();
		// Assuming you want the SKU code of the first item

		Integer res=restTemplate.getForObject("http://localhost:8082/inventory/get/"+skuCode , Integer.class);



		if (quantity<=res) {
			System.out.println(quantity+"quantity os");
			System.out.println(res);
			Order save = orderrepo.save(order);
			System.out.println("order done");
			return new ResponseEntity<String>("Order Placed",HttpStatus.OK);
		}
		else {
			throw new IllegalArgumentException("Only "+res+" quantity of stock is availbe");
		}


	}

	@Override
	public List<Order> getallorders() {
		List<Order> findAll = orderrepo.findAll();
		return findAll;
	}

	@Override
	public Order getorderbyid(Long id) {
		Order order = orderrepo.findById(id).get();
		return order ;
	}

	@Override
	public Order Updateorderbyid(Order order, Long id) {
		Order order2 = orderrepo.findById(id).get();
		order2.setId(order.getId());
		order2.setOrdernumber(UUID.randomUUID().toString());
		order2.setOrderLineItems(order.getOrderLineItems());
		return null;
	}

	@Override
	public ResponseEntity<String> deleteorder(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



}
