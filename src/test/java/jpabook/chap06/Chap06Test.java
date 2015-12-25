package jpabook.chap06;

import jpabook.JpabookApplication;
import jpabook.model.entity.*;
import jpabook.model.entity.item.Album;
import jpabook.repository.*;
import jpabook.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;
import java.util.Arrays;



/**
 * Created by arahansa on 2015-12-19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= JpabookApplication.class)
@WebAppConfiguration
@EnableTransactionManagement
public class Chap06Test {

    public static final String 아라한사 = "아라한사";
    public static final String 인천 = "인천";
    public static final String 전자기기 = "전자기기";
    public static final String 맥북 = "맥북";
    public static final String 남구 = "남구";
    @Autowired
    TestService testService;

    @Test
    public void ObjectGraphTest() throws Exception{
        Order savedOrder = testService.saveMockOrder();
        assertEquals(savedOrder.getMember().getName(),아라한사);
        assertEquals(savedOrder.getMember().getCity(),인천);
        assertEquals(savedOrder.getDelivery().getCity(),인천);
        assertEquals(savedOrder.getOrderItems().get(0).getItem().getName(),맥북);
        System.out.println("겟아티스트 : "+((Album)(savedOrder.getOrderItems().get(0).getItem())).getArtist());
        System.out.println("오더주문 아이디  :"+savedOrder.getId());

    }




}
