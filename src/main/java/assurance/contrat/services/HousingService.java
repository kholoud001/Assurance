package assurance.contrat.services;

import assurance.contrat.model.entities.Housing;

import java.util.List;

public interface HousingService {
    void save(Housing housing);


    List<Housing> getHousingInsurancesForUser(Long userId);

    double calculPrice(Housing housing);
}
