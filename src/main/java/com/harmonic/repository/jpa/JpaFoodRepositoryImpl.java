package com.harmonic.repository.jpa;

import com.harmonic.model.Food;
import com.harmonic.model.Restaurant;
import com.harmonic.repository.FoodRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaFoodRepositoryImpl implements FoodRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Food save(Food food, int restaurantId) {
        food.setRestaurant(em.getReference(Restaurant.class, restaurantId));
        if (food.isNew()) {
            em.persist(food);
            return food;
        } else {
            return em.merge(food);
        }
    }

    @Transactional
    public boolean delete(int id) {
        return em.createQuery("DELETE FROM Food f WHERE f.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    @SuppressWarnings("all")
    public Food get(int id) {
        List<Food> list = em.createQuery("SELECT f FROM Food f WHERE f.id=:id")
                .setParameter("id", id)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }

    @SuppressWarnings("all")
    public List<Food> getAll(int restaurantId) {
        return em.createQuery("SELECT f FROM Food f WHERE f.restaurant.id=:id")
                .setParameter("id", restaurantId)
                .getResultList();
    }
}
