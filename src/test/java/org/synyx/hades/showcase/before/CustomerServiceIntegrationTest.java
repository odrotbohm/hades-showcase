package org.synyx.hades.showcase.before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.synyx.hades.showcase.before.CustomerService;
import org.synyx.hades.showcase.core.Customer;
import org.synyx.hades.showcase.core.AbstractHadesTest;


/**
 * @author Oliver Gierke
 */
public class CustomerServiceIntegrationTest extends AbstractHadesTest {

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
