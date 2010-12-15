package org.synyx.hades.showcase.before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.synyx.hades.domain.Page;
import org.synyx.hades.domain.PageRequest;
import org.synyx.hades.showcase.core.AbstractHadesTest;
import org.synyx.hades.showcase.core.Customer;


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

        Page<Customer> customers =
                repository.findByLastname("Matthews", new PageRequest(0, 2));

        assertThat(customers.asList().size(), is(2));
    }


    @Test
    public void findsCustomerById() throws Exception {

        Customer customer = repository.findById(2L);

        assertThat(customer.getFirstname(), is("Carter"));
        assertThat(customer.getLastname(), is("Beauford"));
    }
}
