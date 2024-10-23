package assurance.contrat.services.impl;

import assurance.contrat.model.entities.Automobile;
import assurance.contrat.repository.AutomobileRep;
import assurance.contrat.services.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AutomobileServiceImpl implements AutomobileService {

    private final AutomobileRep automobileRep;

    @Autowired
    public AutomobileServiceImpl(AutomobileRep automobileRep) {
        this.automobileRep = automobileRep;
    }

    @Override
    public void save(Automobile automobile) {
        automobileRep.save(automobile);
    }
}





