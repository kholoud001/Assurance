package assurance.contrat.repository;

import assurance.contrat.model.entities.Housing;
import org.springframework.transaction.annotation.Transactional;

public interface HousingRep {
    @Transactional
    void save(Housing housing);
}
