package by.it.milosh.REST.model;

import org.springframework.stereotype.Component;

@Component
public class UserRest {

    private String username;

    public UserRest() {
    }

    public UserRest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
