package by.it.milosh.service;

public interface SecurityService {

    /**
     * When user log up, he is becoming Principal object,
     * and his parameters (username, password, role) is stored in authenticationToken.
     * @param username - username
     * @param password - password
     */
    void autoLogin(String username, String password);

}
