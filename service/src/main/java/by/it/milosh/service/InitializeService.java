package by.it.milosh.service;

import by.it.milosh.pojos.User;

public interface InitializeService {

    void initializeRoles();

    User initializeAdmin(User user);

}
