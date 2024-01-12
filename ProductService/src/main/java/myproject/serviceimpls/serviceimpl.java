package myproject.serviceimpls;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import myproject.dto.Productdto;
import myproject.exception.ProductNotFoundexception;
import myproject.model.Product;
import myproject.repo.ProductRepo;
import myproject.service.productservice;
@Service
public class serviceimpl implements productservice {

	@Autowired
	ModelMapper mapper;

	@Autowired
	ProductRepo productRepo;

	@Override
	public Productdto postProduct(Productdto productdto) {
		Product save = productRepo.save(dtoToproduct(productdto));
		return producttodto(save);
	}

	@Override
	public Productdto getProductbyid(int id) {
		Product product = productRepo.findById(id).orElseThrow(()->new ProductNotFoundexception("rock"));

		return producttodto(product);
	}

	@Override
	public List<Productdto> getallproducts() {
		List<Product> findAll = productRepo.findAll();

		return findAll.stream().map(rock->producttodto(rock)).collect(Collectors.toList());

	}

	@Override
	public Productdto updatebyid(Productdto productdto, int id) {
		Product product = productRepo.findById(id).orElseThrow(()->new ProductNotFoundexception("Product with id "+id +"not found"));

		product.setDescription(dtoToproduct(productdto).getDescription());
		product.setId(dtoToproduct(productdto).getId());
		product.setName(dtoToproduct(productdto).getName());
		product.setPrice(dtoToproduct(productdto).getPrice());
		Product save = productRepo.save(product);

		return producttodto(save);
	}

	@Override
	public ResponseEntity<String> deletebyid(int id) {
		productRepo.deleteById(id);
		return new ResponseEntity<String>("Item has been deleted", HttpStatus.OK);
	}

	public Product dtoToproduct(Productdto productdto)
	{
		return mapper.map(productdto, Product.class);
	}
	public Productdto producttodto(Product product)
	{
		return mapper.map(product, Productdto.class);
	}

}
