package assurance.contrat.services.impl;

import assurance.contrat.model.entities.Housing;
import assurance.contrat.services.HousingService;
import assurance.contrat.repository.HousingRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HousingServiceImpl implements HousingService {

    private final HousingRep housingRep;

    @Autowired
    public HousingServiceImpl(HousingRep housingRep) {
        this.housingRep = housingRep;
    }

    @Override
    public void save(Housing housing){
        housingRep.save(housing);
    }
}
