package org.geecon.hades.before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.geecon.hades.core.Customer;
import org.geecon.hades.core.GeeConHadesTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Oliver Gierke
 */
public class CustomerServiceIntegrationTest extends GeeConHadesTest {

    @Autowired
    CustomerService repository;


    @Test
    public void findsAllCustomers() throws Exception {

        List<Customer> result = repository.findAll();

        assertThat(result, is(notNullValue()));
        assertFalse(result.isEmpty());
    }


    @Test
    public void findsPageOfMatthews() throws Exception {

        List<Customer> customers = repository.findByLastname("Matthews", 0, 2);

        assertThat(customers.size(), is(2));
    }


    @Test
    public void findsCustomerById() throws Exception {

        Customer customer = repository.findById(2L);

        assertThat(customer.getFirstname(), is("Carter"));
        assertThat(customer.getLastname(), is("Beauford"));
    }
}
