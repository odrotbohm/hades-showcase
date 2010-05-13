package org.geecon.hades.core;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;


/**
 * @author Oliver Gierke
 */
@ContextConfiguration("classpath*:application-context.xml")
public abstract class GeeConHadesTest extends
        AbstractTransactionalJUnit4SpringContextTests {

    @BeforeTransaction
    public void setupData() throws Exception {

        if (countRowsInTable("Customer") == 0) {
            executeSqlScript("classpath:data.sql", false);
        }
    }
}
