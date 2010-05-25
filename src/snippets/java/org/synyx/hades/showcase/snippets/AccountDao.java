package org.synyx.hades.showcase.snippets;

import java.util.List;

import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.showcase.core.Account;
import org.synyx.hades.showcase.core.Customer;


/**
 * Repository to manage {@link Account} instances.
 * 
 * @author Oliver Gierke
 */
public interface AccountDao extends GenericDao<Account, Long>, AccountDaoCustom {

    /**
     * Returns all accounts belonging to the given {@link Customer}.
     * 
     * @param customer
     * @return
     */
    List<Account> findByCustomer(Customer customer);
}
