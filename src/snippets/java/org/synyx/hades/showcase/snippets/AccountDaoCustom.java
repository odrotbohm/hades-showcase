package org.synyx.hades.showcase.snippets;

import org.joda.time.LocalDate;


/**
 * @author Oliver Gierke
 */
interface AccountDaoCustom {

    void removedExpiredAccounts(LocalDate reference);
}
