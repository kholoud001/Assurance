package assurance.contrat.services;

import assurance.contrat.model.entities.Contract;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

public interface ContractService {
    void addContract(Contract contract);

    Contract getContractById(Long id);

    List<Contract> getAllContracts();

    Contract findByInsuranceId(Long insuranceId);

    void deleteContract(Long id);

    void updateContract(Contract contract);

    List<Contract> getActiveContracts();

//    @Transactional
//    void saveContract(Contract contract, Long insuranceId);
}
