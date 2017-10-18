package by.it.milosh.controllers;

import by.it.milosh.Enums.RoleEnum;
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
import java.util.Locale;
import java.util.ResourceBundle;

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
    private MainService mainService;

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

    /**
     * Go to main page.
     * @return - name of view
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

    /**
     * Go to registration page.
     * @return - name of view
     */
    @RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registration() {
        return "main/registration";
    }

    /**
     * Go to registration page like Student.
     * @param model - org.springframework.web.servlet.ModelAndView
     * @return - name of view
     */
    @RequestMapping(value = {"/registrationStudent"}, method = RequestMethod.GET)
    public String registrationStudent(Model model) {
        model.addAttribute("user", new User());
        return "main/registrationStudent";
    }

    /**
     * Registration like Student.
     * @param user - user from form
     * @param bindingResult - org.springframework.validation.BindingResult
     * @return - name of view
     */
    @RequestMapping(value = "/registrationStudent", method = RequestMethod.POST)
    public String registrationStudent(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "main/registrationStudent";
        }
        userService.saveStudent(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    /**
     * Go to registration page like Teacher.
     * @param model - org.springframework.validation.BindingResult
     * @return - name of view
     */
    @RequestMapping(value = {"/registrationTeacher"}, method = RequestMethod.GET)
    public String registrationTeacher(Model model) {
        model.addAttribute("user", new User());
        return "main/registrationTeacher";
    }

    /**
     * Registration like Teacher.
     * @param user - user from form
     * @param bindingResult - org.springframework.validation.BindingResult
     * @return - name of view
     */
    @RequestMapping(value = "/registrationTeacher", method = RequestMethod.POST)
    public String registrationTeacher(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "main/registrationTeacher";
        }
        userService.saveTeacher(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    /**
     * Go to login page.
     * @param model - org.springframework.web.servlet.ModelAndView
     * @param error - description of error
     * @return - name of view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login (Model model, String error) {
        if (error != null) {
            model.addAttribute("error", "error");
        }
        return "main/login";
    }

    /**
     * Logout and go to main page.
     * @param request - javax.servlet.http.HttpServletRequest;
     * @param response - javax.servlet.http.HttpServletResponse;
     * @return - name of view
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    /**
     * Message about access is denied.
     * @return - name of view
     */
    @RequestMapping(value = "/access_denied", method = RequestMethod.GET)
    public String accessDenied() {
        return "main/access-denied";
    }

    /**
     * Go to admin main page.
     * @return - name of view
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin/admin";
    }

    /**
     * Go to personal page (student or teacher or admin).
     * @param model - org.springframework.web.servlet.ModelAndView
     * @return - model
     */
    @RequestMapping(value = {"/personal"}, method = RequestMethod.GET)
    public ModelAndView personal(ModelAndView model) {
        String roleName = roleService.getRoleNameByUsername(getPrincipal());
        String forwardPage = mainService.determinePersonalPageByUserRole(roleName);
        model.setViewName(forwardPage);
        return model;
    }

}
