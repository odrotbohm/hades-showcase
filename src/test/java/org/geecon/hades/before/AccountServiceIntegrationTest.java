package org.geecon.hades.before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.geecon.hades.core.Account;
import org.geecon.hades.core.Customer;
import org.geecon.hades.core.GeeConHadesTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Oliver Gierke
 */
public class AccountServiceIntegrationTest extends GeeConHadesTest {

    @Autowired
    AccountService accountService;

    @Autowired
    CustomerService customerService;


    @Test
    public void testname() throws Exception {

        Customer customer = customerService.findById(1L);

        List<Account> accounts = accountService.findByCustomer(customer);

        assertFalse(accounts.isEmpty());
        assertThat(accounts.get(0).getCustomer(), is(customer));
    }
}
