package by.it.milosh.controllers;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.Role;
import by.it.milosh.pojos.User;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.CourseService;
import by.it.milosh.service.RoleService;
import by.it.milosh.service.UserCourseService;
import by.it.milosh.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final static Logger logger = Logger.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserCourseService userCourseService;

    @RequestMapping(value = "/allRoles", method = RequestMethod.GET)
    public ModelAndView allRoles(ModelAndView model) {
        List<Role> roles = roleService.getAllRoles();
        model.addObject("roles", roles);
        model.setViewName("admin/allRoles");
        return model;
    }

    @RequestMapping(value = "/allRoles", method = RequestMethod.POST)
    public ModelAndView allRoles(@RequestParam String title, ModelAndView model) {
        Role role = new Role();
        role.setRoleName(title);
        roleService.addEntity(role);
        model.setViewName("redirect:/admin/allRoles");
        return model;
    }

    @RequestMapping(value = "/allCourses", method = RequestMethod.GET)
    public ModelAndView allCourses(ModelAndView model) {
        List<Course> courses = courseService.getAllCourses();
        model.addObject("courses", courses);
        model.setViewName("admin/allCourses");
        return model;
    }

    @RequestMapping(value = "/allCourses", method = RequestMethod.POST)
    public ModelAndView allCourses(@RequestParam String title, ModelAndView model) {
        Course course = new Course();
        course.setCourseName(title);
        courseService.addEntity(course);
        model.setViewName("redirect:/admin/allCourses");
        return model;
    }

    @RequestMapping(value = "/allStudents", method = RequestMethod.GET)
    public ModelAndView allStudents(ModelAndView model) {
        List<User> students = userService.getAllUserByRole("ROLE_STUDENT");
        model.addObject("students", students);
        model.setViewName("admin/allStudents");
        return model;
    }

    @RequestMapping(value = "/allStudentsPagination/{page}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView allStudentsPagination(@PathVariable Integer page, ModelAndView model) {
        int currentPage = 1;
        int usersPerPage = 5;
        if (page != null) {
            currentPage = page;
        }
        List<User> students = userService.getAllUserByRolePagination((currentPage-1)*usersPerPage, usersPerPage, "ROLE_STUDENT");
        long numberOfUsers = userService.numberOfUsersByRole("ROLE_STUDENT");
        int numberOfPages = (int) Math.ceil(numberOfUsers * 1.0 / usersPerPage);
        model.addObject("currentPage", currentPage);
        model.addObject("numberOfPages", numberOfPages);
        model.addObject("students", students);
        model.setViewName("admin/allStudents");
        return model;
    }

    @RequestMapping(value = "/allTeachers", method = RequestMethod.GET)
    public ModelAndView allTeachers(ModelAndView model) {
        List<User> teachers = userService.getAllUserByRole("ROLE_TEACHER");
        model.addObject("teachers", teachers);
        model.setViewName("admin/allTeachers");
        return model;
    }

    @RequestMapping(value = "/allUserCourses", method = RequestMethod.GET)
    public ModelAndView allUserCourses(ModelAndView model) {
        List<UserCourse> userCourses = userCourseService.getAllUserCourse();
        model.addObject("userCourses", userCourses);
        model.setViewName("admin/allUserCourses");
        return model;
    }

}
