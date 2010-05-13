package org.geecon.hades.after;

import java.util.List;

import org.geecon.hades.core.Account;
import org.geecon.hades.core.Customer;
import org.synyx.hades.dao.GenericDao;


/**
 * Repository to manage {@link Account} instances.
 * 
 * @author Oliver Gierke
 */
public interface AccountDao extends GenericDao<Account, Long> {

    /**
     * Returns all accounts belonging to the given {@link Customer}.
     * 
     * @param customer
     * @return
     */
    List<Account> findByCustomer(Customer customer);
}
