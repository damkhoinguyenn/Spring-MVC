package repositories;

import models.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepor extends CrudRepository<Customer, Integer> {

}
