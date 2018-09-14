package com.harmonic.repository.jpa;

import com.harmonic.model.User;
import com.harmonic.repository.UserRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            User existing = get(user.getId());
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            return existing;
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        User u = get(id);
        boolean exists = u != null;
        em.remove(u);
        return exists;
    }

    @Override
    @SuppressWarnings("all")
    public User get(int id) {
        List<User> list = em.createQuery("SELECT u FROM User u WHERE u.id=:id")
                .setParameter("id", id)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }

    @Override
    @SuppressWarnings("all")
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    @SuppressWarnings("all")
    public User getByEmail(String email) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email=:email").setParameter("email", email).getResultList();
        return DataAccessUtils.singleResult(users);
    }
}
