package assurance.contrat.repository;

import assurance.contrat.model.entities.Health;
import org.springframework.transaction.annotation.Transactional;

public interface HealthRep {
    @Transactional
    void save(Health health);
}
