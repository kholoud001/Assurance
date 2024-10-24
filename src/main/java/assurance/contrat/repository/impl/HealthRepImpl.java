package assurance.contrat.repository.impl;

import assurance.contrat.model.entities.Health;
import assurance.contrat.model.entities.User;
import assurance.contrat.repository.HealthRep;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HealthRepImpl implements HealthRep {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Health health) {
        User managedUser = entityManager.merge(health.getUser());
        health.setUser(managedUser);
        entityManager.persist(health);
    }
}
