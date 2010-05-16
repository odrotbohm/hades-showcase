package org.geecon.hades.snippets;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


/**
 * @author Oliver Gierke
 */
@Repository
class AccountDaoJdbcImpl implements AccountDaoCustom {

    @Autowired
    private JdbcTemplate template;


    public void setTemplate(JdbcTemplate template) {

        this.template = template;
    }


    /*
     * (non-Javadoc)
     * 
     * @see
     * org.geecon.hades.after.AccountDaoCustom#removedExpiredAccounts(org.joda
     * .time.LocalDate)
     */
    @Override
    public void removedExpiredAccounts(LocalDate reference) {

        template.update("DELETE Account AS a WHERE a.expiryDate < ?", reference
                .toDateMidnight().toDate());
    }
}
