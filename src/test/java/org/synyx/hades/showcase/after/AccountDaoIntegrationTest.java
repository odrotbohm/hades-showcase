package org.synyx.hades.showcase.after;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.synyx.hades.showcase.core.AbstractHadesTest;
import org.synyx.hades.showcase.core.Account;
import org.synyx.hades.showcase.core.Customer;


/**
 * @author Oliver Gierke
 */
public class AccountDaoIntegrationTest extends AbstractHadesTest {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CustomerDao customerDao;


    @Test
    public void findsCustomersAccounts() throws Exception {

        Customer customer = customerDao.readByPrimaryKey(1L);
        List<Account> accounts = accountDao.findByCustomer(customer);

        assertFalse(accounts.isEmpty());
        assertThat(accounts.get(0).getCustomer(), is(customer));
    }
}
