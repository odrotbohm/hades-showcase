package org.synyx.hades.showcase.snippets;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import org.synyx.hades.showcase.core.Account;


/**
 * @author Oliver Gierke
 */
@Repository
class AccountDaoImpl implements AccountDaoCustom {

    @PersistenceContext
    private EntityManager em;


    /*
     * (non-Javadoc)
     * 
     * @see
     * org.geecon.hades.after.AccountDaoCustom#removedExpiredAccounts(org.joda
     * .time.DateTime)
     */
    @Override
    public void removedExpiredAccounts(LocalDate reference) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = cb.createQuery(Account.class);
        Root<Account> account = query.from(Account.class);

        query.where(cb.lessThan(account.get("expiryDate").as(Date.class),
                reference.toDateMidnight().toDate()));

        for (Account each : em.createQuery(query).getResultList()) {
            em.remove(each);
        }
    }
}
