package assurance.contrat.repository.impl;

import assurance.contrat.model.entities.Housing;
import assurance.contrat.model.entities.User;
import assurance.contrat.repository.HousingRep;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class HousingRepImpl implements HousingRep {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Housing housing) {
        User managedUser = entityManager.merge(housing.getUser());
        housing.setUser(managedUser);
        entityManager.persist(housing);
    }
}
