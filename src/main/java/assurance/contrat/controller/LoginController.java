package assurance.contrat.controller;

import assurance.contrat.model.entities.User;
import assurance.contrat.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView showLoginPage() {
        return new ModelAndView("login");
    }

    @PostMapping
    public ModelAndView loginUser(@ModelAttribute User user) {
        User authenticatedUser = userService.authenticate(user.getEmail(), user.getPassword());

        if (authenticatedUser != null) {
            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("user", authenticatedUser);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }
    }
}
