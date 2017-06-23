package by.it.milosh.validators;

import by.it.milosh.pojos.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "user.username.empty");

        if (user.getUsername().length() < 2 || user.getUsername().length() > 12) {
            errors.rejectValue("username", "user.username.size");
        }

        if (userService.findUserByUsername(user.getUsername()) != null){
            System.out.println("Пользователь существует!");
            errors.rejectValue("username", "user.username.duplicate");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.username.empty");

        if (user.getPassword().length() < 2 || user.getPassword().length() >12) {
            errors.rejectValue("password", "user.password.size");
        }
    }

}
