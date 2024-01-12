package inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MyInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String skucode;
	private Integer quantity;


}
