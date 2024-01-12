package myproject.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import myproject.model.Product;

public interface ProductRepo extends MongoRepository<Product,Integer>{

}
