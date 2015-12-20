package jpabook.chap07;

import jpabook.JpabookApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by arahansa on 2015-12-20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= JpabookApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class Chap07Test {



}
