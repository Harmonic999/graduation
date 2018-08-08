package com.harmonic;

import com.harmonic.model.Food;
import com.harmonic.repository.FoodRepository;
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
    private FoodRepository repository;

    @Test
    public void create() {
        Food created = repository.save(getCreated());
        assertMatch(repository.getAll(), FOOD_1, FOOD_2, FOOD_3, created);
    }

    @Test
    public void delete() {
        repository.delete(FOOD_1.getId());
        assertMatch(repository.getAll(), FOOD_2, FOOD_3);
    }

    @Test
    public void getAll() {
        assertMatch(repository.getAll(), FOOD_1, FOOD_2, FOOD_3);
    }

    @Test
    public void getById() {
        Food loaded = repository.get(FOOD_3.getId());
        assertMatch(loaded, FOOD_3);
    }

    @Test
    public void update() {
        Food loaded = repository.get(3);
        loaded.setDescription("new description");
        loaded.plusVote();
        repository.save(loaded);
        assertMatch(repository.getAll(), FOOD_1, FOOD_2, loaded);
    }

    @Test(expected = Exception.class)
    public void deleteNotFound() throws Exception {
        if (!repository.delete(4)) {
            throw new Exception();
        }
    }

    @Test(expected = Exception.class)
    public void getNotFoundById() throws Exception {
        if (repository.get(4) == null) {
            throw new Exception();
        }
    }

}
