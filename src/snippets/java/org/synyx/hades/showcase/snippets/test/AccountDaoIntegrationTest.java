package org.synyx.hades.showcase.snippets.test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.synyx.hades.showcase.snippets.AccountDao;


/**
 * @author Oliver Gierke
 */
public class AccountDaoIntegrationTest {

    private AccountDao accountDao;


    public void testname() throws Exception {

        accountDao.removedExpiredAccounts(new LocalDate(2011, 1, 1));

        assertThat(accountDao.count(), is(1L));
    }
}
