package by.it.milosh.controllers;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.CourseService;
import by.it.milosh.service.UserCourseService;
import by.it.milosh.service.UserService;
import by.it.milosh.validators.CourseValidator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StudentController {
    private final static Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserCourseService userCourseService;

    @Autowired
    private CourseValidator courseValidator;

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
     * Go to personal student page.
     * @param model - org.springframework.web.servlet.ModelAndView
     * @return - model
     */
    @RequestMapping(value = {"/personalStudent"}, method = RequestMethod.GET)
    public ModelAndView personal(ModelAndView model) {
        List<String> courseNames = userService.getAllCourseNames();
        Long userId = userService.findUserByUsername(getPrincipal()).getUserId();
        List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(userId);
        model.addObject("courseNames", courseNames);
        model.addObject("userCourses", userCourses);
        model.addObject("course", new Course());
        model.setViewName("student/personalStudent");
        return model;
    }

    /**
     * Student enroll for this course.
     * If he already enrolled for this course, a message is sent about this.
     * @param course - course from form
     * @param bindingResult - org.springframework.validation.BindingResult
     * @param model - org.springframework.web.servlet.ModelAndView
     * @return - model
     */
    @RequestMapping(value = "/personalStudent", method = RequestMethod.POST)
    public ModelAndView personal(@Valid @ModelAttribute("course") Course course,
                                 BindingResult bindingResult,
                                 ModelAndView model){
        courseValidator.validate(course, bindingResult);
        if (bindingResult.hasErrors()) {
            Long userId = userService.findUserByUsername(getPrincipal()).getUserId();
            List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(userId);
            List<String> courseNames = userService.getAllCourseNames();
            model.addObject("courseNames", courseNames);
            model.addObject("userCourses", userCourses);
            model.setViewName("student/personalStudent");
            return model;
        }
        userService.addCourseToUser(getPrincipal(), course.getCourseName());
        model.setViewName("redirect:/personalStudent");
        return model;
    }

}
