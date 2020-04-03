package kg.iaau.edu.com.dao;

import kg.iaau.edu.com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class CustomerDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> getCustomers()
    {
        return jdbcTemplate.query("select * from northwind", new RowMapper<Customer>() {
            public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                Customer customer = new Customer();

                customer.setId(resultSet.getInt("id"));
                customer.setFirstName(resultSet.getString("firstName"));
                customer.setLastName(resultSet.getString("lastName"));
                customer.setGroupName(resultSet.getString("groupName"));
                return customers;
            }
        });
    }

    public Customer getCustomer(int id)
    {
        String sql = "SELECT * FROM customers WHERE id = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Student student = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return student;
    }

    public boolean delete(int id)
    {
        return jdbcTemplate.update("delete from customers where id = ?", id) == 1;
    }

    public boolean create(CustomerDao customerDao)
    {
        return jdbcTemplate.update("insert into customers (id, firstName, lastName, emailAddress, jobTitle, mobilePhone, city, webPage) values (?, ?, ?)", customers.getFirstName(), customers.getLastName(), customers.emailAddress(), customers.jobTitle, customers.mobilePhone, customers.mobilePhone, customers.city, customers.webPage) == 1;
    }

    public boolean update(Customer customer)
    {
        return jdbcTemplate.update("update customer set firstName =?, lastName=?, emailAddress=?, jobTitle=?,mobilePhone=?,city=?, webPage=?  where id=?", customers.getFirstName(), customers.getLastName(), customers.EmailAddress(), customers.JobTitle(), customers.getMobilePhone(), customers.getCity(), customers.getWebPage()) == 1;
    }
}