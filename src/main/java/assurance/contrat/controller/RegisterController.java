package assurance.contrat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping
    public ModelAndView showRegisterPage() {
        return new ModelAndView("register");
    }

}
