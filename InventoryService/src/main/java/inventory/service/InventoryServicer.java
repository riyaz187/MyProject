package inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import inventory.model.MyInventory;
import inventory.repo.MyRepo;

@Service
public class InventoryServicer {

	@Autowired
	private MyRepo myRepo;

	@Transactional(readOnly = true)
	public String ispresentinstock(String skucode) {
		try {
			MyInventory item = myRepo.findByskucode(skucode);
			return item.getSkucode();

		} catch (Exception e) {
			throw new IllegalArgumentException("item not found ..will load this item soon");
		}





	}






}
