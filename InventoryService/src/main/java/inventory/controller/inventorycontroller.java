package inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inventory.service.InventoryServicer;

@RestController
@RequestMapping("/inventory")

public class inventorycontroller {



	@Autowired
	InventoryServicer inventoryService;





	@GetMapping("/get/{skucode}")
	public String isinstock(@PathVariable String skucode)
	{
		return inventoryService.ispresentinstock(skucode);

	}

}
