package by.it.milosh.service;

import by.it.milosh.pojos.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    List<User> getAllUsers();

    User findUserByUsername(String username);

    List<User> getAllUserByRole(String roleName);

    List<String> getAllCourseNames();

    void addCourseToUser(String username, String courseName);

    List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName);

    Long numberOfUsersByRole(String roleName);

}
