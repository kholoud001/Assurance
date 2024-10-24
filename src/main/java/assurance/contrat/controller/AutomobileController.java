package assurance.contrat.controller;

import assurance.contrat.model.entities.Automobile;
import assurance.contrat.model.entities.User;
import assurance.contrat.model.enums.InsuranceType;
import assurance.contrat.services.AutomobileService;
import assurance.contrat.services.VehicleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/automobile")
public class AutomobileController {

    private final VehicleService vehicleService;
    private final AutomobileService automobileService;

    @Autowired
    public AutomobileController(VehicleService vehicleService, AutomobileService automobileService){
        this.vehicleService= vehicleService;
        this.automobileService= automobileService;
    }


    @GetMapping("/form")
    public String showAutomobileForm(Model model) {
        model.addAttribute("automobile", new Automobile());

        model.addAttribute("insuranceTypes", List.of(InsuranceType.values()));

        model.addAttribute("vehicles", vehicleService.findAll());

        return "forms/automobile_insurance";
    }

    @PostMapping("/submit")
    public String submitAutomobileForm(@ModelAttribute Automobile automobile, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user != null) {
            automobile.setUser(user);
            // Change later the price
            automobile.setPrice(0.0);
            automobileService.save(automobile);
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

}
