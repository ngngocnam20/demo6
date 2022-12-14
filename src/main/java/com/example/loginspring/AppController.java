package com.example.loginspring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String viewLoginPage(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }
    @GetMapping("")
    public String viewHomePage(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @GetMapping("/register")
    public String showSignUpForm(Model model)
    {
        model.addAttribute("user", new User());

        return "signup_form";
    }


    @PostMapping("/process_register")
    public String processingRegistration(User user)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        repository.save(user);
        return "register_success";
    }
}
