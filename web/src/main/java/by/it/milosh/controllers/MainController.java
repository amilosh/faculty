package by.it.milosh.controllers;

import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.service.*;
import by.it.milosh.validators.UserValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping
public class MainController {
    private final static Logger logger = Logger.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    @Qualifier("baseService")
    private BaseService baseService;

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        }
        else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registration() {
        return "main/registration";
    }

    @RequestMapping(value = {"/registrationStudent"}, method = RequestMethod.GET)
    public String registrationStudent(Model model) {
        model.addAttribute("user", new User());
        return "main/registrationStudent";
    }

    @RequestMapping(value = "/registrationStudent", method = RequestMethod.POST)
    public String registrationStudent(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "main/registrationStudent";
        }
        Role role = roleService.getRoleByRoleName("ROLE_STUDENT");
        user.setRole(role);
        userService.addEntity(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    @RequestMapping(value = {"/registrationTeacher"}, method = RequestMethod.GET)
    public String registrationTeacher(Model model) {
        model.addAttribute("user", new User());
        return "main/registrationTeacher";
    }

    @RequestMapping(value = "/registrationTeacher", method = RequestMethod.POST)
    public String registrationTeacher(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "main/registrationTeacher";
        }
        Role role = roleService.getRoleByRoleName("ROLE_TEACHER");
        user.setRole(role);
        userService.addEntity(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login (Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        return "main/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "main/access-denied";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin/admin";
    }

    @RequestMapping(value = {"/personal"}, method = RequestMethod.GET)
    public ModelAndView personal(ModelAndView model) {
        String forwardPage = "";
        String roleName = roleService.getRoleNameByUsername(getPrincipal());
        if (roleName.equals("ROLE_STUDENT")) {
            forwardPage = "redirect:/personalStudent";
        } else if (roleName.equals("ROLE_TEACHER")) {
            forwardPage = "redirect:/personalTeacher";
        } else if (roleName.equals("ROLE_ADMIN")) {
            forwardPage = "admin/admin";
        }
        model.setViewName(forwardPage);
        return model;
    }

}
