package org.synyx.hades.showcase.after;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.synyx.hades.domain.Page;
import org.synyx.hades.domain.PageRequest;
import org.synyx.hades.showcase.after.CustomerDao;
import org.synyx.hades.showcase.core.Customer;
import org.synyx.hades.showcase.core.AbstractHadesTest;


/**
 * @author Oliver Gierke
 */
public class CustomerDaoIntegrationTest extends AbstractHadesTest {

    @Autowired
    CustomerDao repository;


    @Test
    public void findsAllCustomers() throws Exception {

        List<Customer> result = repository.readAll();

        assertThat(result, is(notNullValue()));
        assertFalse(result.isEmpty());
    }


    @Test
    public void findsFirstPageOfMatthews() throws Exception {

        Page<Customer> customers =
                repository.findByLastname("Matthews", new PageRequest(0, 2));

        assertThat(customers.asList().size(), is(2));
        assertFalse(customers.hasPreviousPage());
    }


    @Test
    public void findsCustomerById() throws Exception {

        Customer customer = repository.readByPrimaryKey(2L);

        assertThat(customer.getFirstname(), is("Carter"));
        assertThat(customer.getLastname(), is("Beauford"));
    }
}
