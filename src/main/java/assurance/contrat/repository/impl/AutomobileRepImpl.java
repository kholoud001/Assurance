package assurance.contrat.repository.impl;

import assurance.contrat.model.entities.Automobile;
import assurance.contrat.model.entities.User;
import assurance.contrat.repository.AutomobileRep;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AutomobileRepImpl implements AutomobileRep {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Automobile automobile) {
        User managedUser = entityManager.merge(automobile.getUser());
        automobile.setUser(managedUser);
        entityManager.persist(automobile);
    }






}
