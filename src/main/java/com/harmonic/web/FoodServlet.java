package com.harmonic.web;

import com.harmonic.model.Food;
import com.harmonic.repository.FoodRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FoodServlet extends HttpServlet {

    private FoodRepository repository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ConfigurableApplicationContext springContext = new ClassPathXmlApplicationContext("spring/spring-db.xml");
        repository = springContext.getBean(FoodRepository.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/foodList.jsp").forward(request, response);
    }
}
