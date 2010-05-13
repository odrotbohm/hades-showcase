package org.geecon.hades.before;

import java.util.List;

import org.geecon.hades.core.Account;
import org.geecon.hades.core.Customer;


/**
 * @author Oliver Gierke
 */
public interface AccountService {

    Account save(Account account);


    List<Account> findByCustomer(Customer customer);
}
