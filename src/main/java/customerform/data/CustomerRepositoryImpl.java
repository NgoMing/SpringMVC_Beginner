package customerform.data;

import customerform.domain.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("raw-repository")
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
