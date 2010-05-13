package org.geecon.hades.after;

import java.util.List;

import org.geecon.hades.core.Customer;
import org.synyx.hades.dao.GenericDao;
import org.synyx.hades.domain.Page;
import org.synyx.hades.domain.Pageable;


/**
 * Repository to manage {@link Customer} instances.
 * 
 * @author Oliver Gierke
 */
public interface CustomerDao extends GenericDao<Customer, Long> {

    /**
     * Returns all {@link Customer}s with the given lastname.
     * 
     * @param lastname
     * @return
     */
    List<Customer> findByLastname(String lastname);


    /**
     * Returns a page of {@link Customer}s with the given lastname.
     * 
     * @param lastname
     * @param pageable
     * @return
     */
    Page<Customer> findByLastname(String lastname, Pageable pageable);
}
