package com.asiainfo.worktime.configure;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfigurationTest.class })
@EnableTransactionManagement
public class BaseJUnit4Test 
//extends AbstractTransactionalJUnit4SpringContextTests
{

}
