package org.synyx.hades.showcase.before;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.synyx.hades.showcase.before.AccountService;
import org.synyx.hades.showcase.before.CustomerService;
import org.synyx.hades.showcase.core.Account;
import org.synyx.hades.showcase.core.Customer;
import org.synyx.hades.showcase.core.AbstractHadesTest;


/**
 * @author Oliver Gierke
 */
public class AccountServiceIntegrationTest extends AbstractHadesTest {

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
