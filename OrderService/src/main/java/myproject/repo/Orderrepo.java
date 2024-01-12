package myproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import myproject.model.Order;


public interface Orderrepo extends JpaRepository<Order, Long> {

}
