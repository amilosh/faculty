package by.it.milosh.controllers;

import by.it.milosh.Enums.RoleEnum;
import by.it.milosh.pojos.User;
import by.it.milosh.service.InitializeService;
import by.it.milosh.service.UserService;
import by.it.milosh.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StartController {

    @Autowired
    private InitializeService initializeService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/setup"}, method = RequestMethod.GET)
    public String setup(Model model) {
        // check whether the admin is initialized
        List<User> roles = userService.getAllUserByRole(RoleEnum.ADMIN.getType());
        if (!roles.isEmpty()) {
            String adminIsSetup = "adminIsSetup";
            model.addAttribute("adminIsSetup", adminIsSetup);
        }
        model.addAttribute("user", new User());
        return "main/setup";
    }

    @RequestMapping(value = "/setup", method = RequestMethod.POST)
    public String setup(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "main/registrationStudent";
        }
        initializeService.initializeRoles();
        initializeService.initializeAdmin(user);
        return "redirect:/";
    }

}
