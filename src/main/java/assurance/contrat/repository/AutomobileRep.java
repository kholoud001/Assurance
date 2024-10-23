package assurance.contrat.repository;

import assurance.contrat.model.entities.Automobile;
import org.springframework.transaction.annotation.Transactional;

public interface AutomobileRep {
    @Transactional
    void save(Automobile automobile);
}
