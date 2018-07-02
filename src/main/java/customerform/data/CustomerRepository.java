package customerform.data;

import customerform.domain.Customer;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer findByUserName(String username);

}
