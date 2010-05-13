package org.geecon.hades.after;

import static org.hamcrest.Matchers.*;
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
public class AccountDaoIntegrationTest extends GeeConHadesTest {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CustomerDao customerDao;


    @Test
    public void testname() throws Exception {

        Customer customer = customerDao.readByPrimaryKey(1L);

        List<Account> accounts = accountDao.findByCustomer(customer);

        assertFalse(accounts.isEmpty());
        assertThat(accounts.get(0).getCustomer(), is(customer));
    }
}
