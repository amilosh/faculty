package by.it.milosh.validators;

import by.it.milosh.pojos.Course;
import by.it.milosh.pojos.UserCourse;
import by.it.milosh.service.CourseService;
import by.it.milosh.service.UserCourseService;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;

@Component
public class CourseValidator implements Validator {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserCourseService userCourseService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Course.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Course course = (Course) o;

        Long user_id = userService.findUserByUsername(getPrincipal()).getUser_id();
        List<UserCourse> userCourses = userCourseService.getAllUserCourseByUserId(user_id);
        Course course1 = courseService.findCourseByName(course.getCourseName());
        Long course1_id = course1.getCourse_id();
        boolean checkCourse = true;
        for (int i = 0; i < userCourses.size(); i++) {
            if (userCourses.get(i).getCourse().getCourse_id() == course1_id) {
                checkCourse = false;
            }
        }
        if (!checkCourse) {
            errors.reject("course.already.use");
        }

    }

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

}
