package jpabook.chap06;

import jpabook.JpabookApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by arahansa on 2015-12-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= JpabookApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class Chap06Test {

    @Test
    public void test() throws Exception{

    }

    @Service
    @Transactional
    public static class TestService{

    }

}
