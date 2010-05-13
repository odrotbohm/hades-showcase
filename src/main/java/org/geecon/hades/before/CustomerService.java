package org.geecon.hades.before;

import java.util.List;

import org.geecon.hades.core.Customer;


/**
 * @author Oliver Gierke
 */
public interface CustomerService {

    Customer findById(Long id);


    Customer save(Customer customer);


    List<Customer> findAll();


    List<Customer> findAll(int page, int pageSize);


    List<Customer> findByLastname(String lastname, int page, int pageSize);
}
