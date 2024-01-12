package myproject.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import myproject.dto.Productdto;


public interface productservice {

	public Productdto postProduct(Productdto productdto);

	public Productdto getProductbyid(int id);
	public List<Productdto>getallproducts();
	public Productdto updatebyid(Productdto productdto,int id);
	public ResponseEntity<String> deletebyid(int id);

}
