package com.harmonic;

import com.harmonic.model.Food;
import com.harmonic.service.FoodService;
import com.harmonic.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.harmonic.FoodTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-conf.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)

@Sql(scripts = {"classpath:database/createDB.sql", "classpath:database/populateDB.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public class FoodServiceTest {

    @Autowired
    private FoodService service;

    @Test
    public void create() {
        Food created = service.save(getCreated(), RESTAURANT_1_ID);
        assertMatch(service.getAll(RESTAURANT_1_ID), FOOD_1, FOOD_2, FOOD_3, created);
    }

    @Test
    public void delete() {
        service.delete(FOOD_1.getId());
        assertMatch(service.getAll(RESTAURANT_1_ID), FOOD_2, FOOD_3);
    }

    @Test
    public void getAll() {
        assertMatch(service.getAll(RESTAURANT_1_ID), FOOD_1, FOOD_2, FOOD_3);
    }

    @Test
    public void getById() {
        Food loaded = service.get(FOOD_3.getId());
        assertMatch(loaded, FOOD_3);
    }

    @Test
    public void update() {
        Food loaded = service.get(3);
        loaded.setDescription("new description");
        service.save(loaded, RESTAURANT_1_ID);
        assertMatch(service.getAll(RESTAURANT_1_ID), FOOD_1, FOOD_2, loaded);
    }

    @Test(expected = NotFoundException.class)
    public void deleteNotFound() throws Exception {
        service.delete(7);
    }

    @Test(expected = NotFoundException.class)
    public void getNotFoundById() throws Exception {
        service.get(7);
    }

}
