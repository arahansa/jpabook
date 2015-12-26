package jpabook.chap08;

import jpabook.JpabookApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by jarvis on 15. 12. 26..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= JpabookApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class Chap08Test {

    @Autowired Chap08Service service;

    @Test
    public void test() throws Exception{
        service.saveTest();
    }
}
