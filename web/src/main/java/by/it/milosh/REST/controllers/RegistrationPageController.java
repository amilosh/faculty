package by.it.milosh.REST.controllers;

import by.it.milosh.REST.model.RegistrationPageResponse;
import by.it.milosh.REST.model.UserRequest;
import by.it.milosh.pojos.User;
import by.it.milosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationPageController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/checkUsername", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    RegistrationPageResponse checkUsername(@RequestBody UserRequest userRequest) {
        String username = userRequest.getUsername();

        User user = userService.findUserByUsername(username);

        RegistrationPageResponse response = new RegistrationPageResponse();

        if (user == null) {
            response.setMessage("false");
        } else {
            response.setMessage("true");
        }

        return response;
    }

}
