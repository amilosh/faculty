package by.it.milosh.REST.controller;

import by.it.milosh.REST.model.Response;
import by.it.milosh.REST.model.UserRest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {

    @PostMapping(value = "/save")
    public Response postCustomer(@RequestBody UserRest userRest) {
        //userRests.add(userRest);

        String username = userRest.getUsername();

        // Create Response Object
        Response response = new Response("Done", userRest);
        return response;
    }

}
