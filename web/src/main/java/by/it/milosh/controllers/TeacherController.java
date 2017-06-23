package by.it.milosh.controllers;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.CourseService;
import by.it.milosh.service.UserCourseService;
import by.it.milosh.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TeacherController {
    private final static Logger logger = Logger.getLogger(TeacherController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserCourseService userCourseService;

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

    @RequestMapping(value = {"/personalTeacher"}, method = RequestMethod.GET)
    public ModelAndView personal(ModelAndView model) {
        List<String> courseNames = userService.getAllCourseNames();
        model.addObject("courseNames", courseNames);
        Long user_id = userService.findUserByUsername(getPrincipal()).getUser_id();
        List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(user_id);
        model.addObject("userCourses", userCourses);
        model.addObject("course", new Course());
        if (userCourses.isEmpty()) {

        } else {
            Long course_id = userCourses.get(0).getCourse().getCourse_id();
            List<UserCourse> studentsList = userCourseService.getAllUserCourseByCourseId(course_id);
            model.addObject("studentsList", studentsList);
        }
        model.setViewName("teacher/personalTeacher");
        return model;
    }

    @RequestMapping(value = "/personalTeacher", method = RequestMethod.POST)
    public ModelAndView personal(@ModelAttribute("course") Course course,
                                 BindingResult bindingResult,
                                 ModelAndView model){
        if (bindingResult.hasErrors()) {
            model.setViewName("student/personalStudent");
        }
        String courseName = course.getCourseName();
        Long course_id = courseService.findCourseByName(courseName).getCourse_id();
        List<UserCourse> userCoursesList = userCourseService.checkTeacherCourse(course_id);
        if (userCoursesList.isEmpty()) {
            userService.addCourseToUser(getPrincipal(), course.getCourseName());
            Long user_id = userService.findUserByUsername(getPrincipal()).getUser_id();
            List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(user_id);
            model.addObject("userCourses", userCourses);
            model.setViewName("redirect:/personalTeacher");

        } else {
            List<String> courseNames = userService.getAllCourseNames();
            model.addObject("courseNames", courseNames);
            String check = "Этот курс уже заянт другим проподом.";
            model.addObject("check", check);
            model.setViewName("teacher/personalTeacher");
        }
        return model;
    }

    @RequestMapping(value = {"/makeAsses"}, method = RequestMethod.POST)
    public ModelAndView makeAsses(@RequestParam Long user_course_id,
                                  @RequestParam Integer rating,
                                  ModelAndView model) {
        UserCourse userCourse = userCourseService.getEntityById(UserCourse.class, user_course_id);
        userCourse.setRating(rating);
        userCourseService.updateEntity(userCourse);
        Long course_id = 1L;
        List<UserCourse> userCourses = userCourseService.getAllUserCourseByCourseId(course_id);
        model.addObject("userCourses", userCourses);
        model.setViewName("redirect:/personalTeacher");
        return model;
    }

}
