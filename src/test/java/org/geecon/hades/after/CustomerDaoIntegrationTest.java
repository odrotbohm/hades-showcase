package org.geecon.hades.after;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.geecon.hades.core.Customer;
import org.geecon.hades.core.GeeConHadesTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.synyx.hades.domain.Page;
import org.synyx.hades.domain.PageRequest;


/**
 * @author Oliver Gierke
 */
public class CustomerDaoIntegrationTest extends GeeConHadesTest {

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
    }
}
