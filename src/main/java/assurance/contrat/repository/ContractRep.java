package assurance.contrat.repository;

import assurance.contrat.model.entities.Contract;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ContractRep {
    @Transactional
    void save(Contract contract);

    Contract findById(Long id);

    List<Contract> findAll();

    Contract findByInsuranceId(Long insuranceId);

    @Transactional
    void delete(Long id);
}
