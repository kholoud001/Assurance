package assurance.contrat.services.impl;

import assurance.contrat.model.entities.Health;
import assurance.contrat.repository.HealthRep;
import assurance.contrat.services.HealthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    private final HealthRep healthRep;

    @Autowired
    public HealthServiceImpl(HealthRep healthRep) {
        this.healthRep = healthRep;
    }

    @Override
    public void save(Health health){
        healthRep.save(health);
    }
}
