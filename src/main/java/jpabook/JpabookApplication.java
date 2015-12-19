package jpabook;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import jpabook.model.entity.Member;
import jpabook.model.entity.Order;

@SpringBootApplication
public class JpabookApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpabookApplication.class, args);
    }
    
   
}
