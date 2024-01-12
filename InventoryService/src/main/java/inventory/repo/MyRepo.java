package inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inventory.model.MyInventory;
@Repository
public interface MyRepo extends JpaRepository<MyInventory, Long>{

	MyInventory findByskucode(String skucode);



}
