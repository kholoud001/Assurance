package assurance.contrat.controller;

import assurance.contrat.model.entities.Automobile;
import assurance.contrat.model.entities.Contract;
import assurance.contrat.model.enums.InsuranceType;
import assurance.contrat.services.AutomobileService;
import assurance.contrat.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private AutomobileService automobileService;

    @Autowired
    private ContractService contractService;


    @GetMapping("/list")
    public String viewContracts(Model model) {
        List<Contract> activeContracts = contractService.getActiveContracts();
        model.addAttribute("contracts", activeContracts);
        return "contracts";
    }

    @GetMapping("/automobile")
    public String showContractForm(@RequestParam("insuranceId") Long insuranceId, Model model) {
        System.out.println("Entered showContractForm method with insuranceId: " + insuranceId);
        Contract existingContract = contractService.findByInsuranceId(insuranceId);

        if (existingContract != null) {
            System.out.println("Existing Contract ID: " + existingContract.getId());
            return "redirect:/contract/list";
        } else {
            System.out.println("No existing contract found, proceeding to create a new one.");
        }
        LocalDate subscriptionDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = subscriptionDate.format(formatter);

        System.out.println("id captured: " + insuranceId);
        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("insuranceId", insuranceId);
        model.addAttribute("contract", new Contract());

        return "forms/contract";
    }



    @PostMapping("/submit")
    public String submitContract(
            @ModelAttribute("contract") Contract contract,
            @RequestParam("document") MultipartFile document,
            RedirectAttributes redirectAttributes) {

        System.out.println("contract id " + contract.getId());
        Automobile automobile = automobileService.findById(contract.getId());

        if (automobile != null) {
            contract.setInsurance(automobile);
            contract.setSubscriptionDate(LocalDate.now());
            contract.setExpirationDate(LocalDate.now().plusDays(30));
            contract.setStatus(true);

            String documentPath = saveDocument(document);
            contract.setDocumentPath(documentPath);

            contractService.addContract(contract);

            redirectAttributes.addFlashAttribute("successMessage", "Contract generated successfully.");
            redirectAttributes.addFlashAttribute("formattedDate", DateTimeFormatter.ofPattern("yyyy-MM-dd").format(contract.getSubscriptionDate()));
            return "redirect:/contract/list";
        }

        return "redirect:/automobile";
    }


    private String saveDocument(MultipartFile document) {
        if (document.isEmpty()) {
            return null;
        }

        try {
            String uploadDir = "C:/jee/contrat/src/main/webapp/files";
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String uniqueFilename = UUID.randomUUID().toString() + "_" + document.getOriginalFilename();
            Path filePath = uploadPath.resolve(uniqueFilename);
            Files.copy(document.getInputStream(), filePath);

            return filePath.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }












}
