package customerform.data;

import customerform.domain.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRepositoryImpl implements CustomerRepository {

    List<Customer> customerList = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {

        customerList.add(customer);

        return customer;
    }

    @Override
    public Customer findByUserName(String username) {

        Customer returnValue = null;

        for (Customer customer: customerList) {
            if (username.equals(customer.getUsername()))
                returnValue = customer;
        }

        return returnValue;
    }
}
