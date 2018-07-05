package customerform.data.jdbc;

import customerform.data.CustomerRepository;
import customerform.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    JdbcOperations jdbc;

    @Autowired
    public JdbcCustomerRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Customer save(Customer customer) {
        jdbc.update(
            "insert into Customer (username, password, full_name, email)" +
                    " values (?, ?, ?, ?)",
            customer.getUsername(),
            customer.getPassword(),
            customer.getFullName(),
            customer.getEmail());
        return customer;
    }

    @Override
    public Customer findByUserName(String username) {
        return jdbc.queryForObject(
            "select id, username, password, full_name, email from Customer where username=?",
//                new CustomerRowMapper(),
            this::mapCustomer,
            username);
    }

    Customer mapCustomer(ResultSet rs, int rowNum) throws SQLException {
        return new Customer(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("password"),
            rs.getString("full_name"),
            rs.getString("email"));
    }
}
