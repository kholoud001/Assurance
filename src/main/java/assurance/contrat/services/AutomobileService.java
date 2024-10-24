package assurance.contrat.services;

import assurance.contrat.model.entities.Automobile;

public interface AutomobileService {
    void save(Automobile automobile);

    double calculPrice(Automobile automobile);
}
