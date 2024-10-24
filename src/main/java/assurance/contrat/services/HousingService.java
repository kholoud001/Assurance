package assurance.contrat.services;

import assurance.contrat.model.entities.Housing;

public interface HousingService {
    void save(Housing housing);

    double calculPrice(Housing housing);
}
