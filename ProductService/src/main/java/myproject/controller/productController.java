package myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myproject.dto.Productdto;
import myproject.service.productservice;

@RestController
@RequestMapping("/product")
public class productController {

	@Autowired
	productservice productservice;

	@PostMapping("/post")
	public Productdto  postmyproduct(@RequestBody Productdto productdto)
	{
		return  productservice.postProduct(productdto);
	}
	@GetMapping("/get/{id}")
	public Productdto readone(@PathVariable int id)
	{
		return  productservice.getProductbyid(id);
	}

	@GetMapping("/getall")
	public List<Productdto>getall()
	{
		return productservice.getallproducts();
	}
	@PutMapping("/update/{id}")
	public Productdto updatebyid(@RequestBody Productdto productdto,@PathVariable int id)
	{
		return	productservice.updatebyid(productdto, id);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteit(@PathVariable int id)
	{
		return	productservice.deletebyid(id);
	}

}
