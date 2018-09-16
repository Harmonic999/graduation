package com.harmonic.repository.jpa;

import com.harmonic.model.VotesAccountant;
import com.harmonic.repository.VotesAccountantRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaVotesAccountantRepositoryImpl implements VotesAccountantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("all")
    public VotesAccountant get(int id) {
        List<VotesAccountant> list = em.createQuery("SELECT v FROM VotesAccountant v WHERE v.id=:id")
                .setParameter("id", id)
                .getResultList();
        return DataAccessUtils.singleResult(list);
    }

    @Override
    @Transactional
    public VotesAccountant save(VotesAccountant accountant) {
        VotesAccountant existing = get(accountant.getUserId());
        if (existing == null) {
            em.persist(accountant);
            return accountant;
        } else {
            existing.setRestaurantId(accountant.getRestaurantId());
            return existing;
        }
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        VotesAccountant accountant = get(id);
        boolean exists = accountant != null;
        em.remove(accountant);
        return exists;
    }

    @Override
    @SuppressWarnings("all")
    public List<VotesAccountant> getAll() {
        return em.createQuery("SELECT v FROM VotesAccountant v").getResultList();
    }


}
