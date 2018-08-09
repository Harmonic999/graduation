package com.harmonic.repository.jpa;

import com.harmonic.model.Restaurant;
import com.harmonic.repository.RestaurantRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaRestaurantRepositoryImpl implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    @Transactional
    public boolean delete(int id) {
        return em.createQuery("DELETE FROM Restaurant r WHERE r.id=:id")
                .setParameter("id", id).executeUpdate() != 0;
    }

    @SuppressWarnings("all")
    public Restaurant get(int id) {
        List<Restaurant> list = em.createQuery("SELECT r FROM Restaurant r WHERE r.id=:id")
                .setParameter("id", id)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }

    @SuppressWarnings("all")
    public List<Restaurant> getAll() {
        return em.createQuery("SELECT r FROM Restaurant r").getResultList();
    }

}
