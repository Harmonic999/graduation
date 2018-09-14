package com.harmonic;

import com.harmonic.model.Role;
import com.harmonic.model.User;
import com.harmonic.repository.FoodRepository;
import com.harmonic.repository.UserRepository;
import com.harmonic.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
                "spring/spring-conf.xml",
                "spring/spring-db.xml"
        );

        UserService service = context.getBean(UserService.class);
        //userRepository.save(new User(null, "user_7", "user_7@gmail.com", "password", Role.ROLE_USER, Role.ROLE_ADMIN));
        service.save(new User(null, "hello", "hello@gmail.com", "password", Role.ROLE_USER));
    }
}
