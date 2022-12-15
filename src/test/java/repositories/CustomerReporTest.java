package repositories;

import models.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CustomerReporTest {
    @Autowired private CustomerRepor repor;
    @Test
    public void testAdd(){
        Customer customer= new Customer();
        customer.setName("Nguyen");
        customer.setAddress("Ha Noi");
        repor.save(customer);
    }
}
