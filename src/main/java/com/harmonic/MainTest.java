package com.harmonic;

import com.harmonic.repository.FoodRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/spring-conf.xml",
                "spring/spring-db.xml"
        );
        FoodRepository repository = context.getBean(FoodRepository.class);
        System.out.println(repository.getAll().size());
    }
}
