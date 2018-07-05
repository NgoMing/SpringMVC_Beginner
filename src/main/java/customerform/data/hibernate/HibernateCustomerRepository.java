package customerform.data.hibernate;

import customerform.data.CustomerRepository;
import customerform.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.Serializable;

@Repository
@Profile("hibernate-repository")
public class HibernateCustomerRepository implements CustomerRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateCustomerRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Customer save(Customer customer) {
        Serializable id = currentSession().save(customer);
        return new Customer((Long) id,
                customer.getUsername(),
                customer.getPassword(),
                customer.getFullName(),
                customer.getEmail());
    }

    @Override
    public Customer findByUserName(String username) {
        return (Customer) currentSession()
                .createCriteria(Customer.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }
}
