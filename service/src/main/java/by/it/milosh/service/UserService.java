package by.it.milosh.service;

import by.it.milosh.pojos.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    /**
     * Extract all Users from DB.
     * @return - list of all users
     */
    List<User> getAllUsers();

    /**
     * Extract one user from DB by username.
     * @param username - username of user
     * @return - user with this username
     */
    User findUserByUsername(String username);

    /**
     * Extract all Users by his role.
     * @param roleName - name of role
     * @return - list of all users with this role
     */
    List<User> getAllUserByRole(String roleName);

    /**
     * Extract all course names from DB.
     * @return - list of course names
     */
    List<String> getAllCourseNames();

    /**
     * User is subscribing on course.
     * @param username - username of user
     * @param courseName - courseName of course
     */
    void addCourseToUser(String username, String courseName);

    /**
     * Extract all users, which has specific role, using pagination.
     * Role is determined by role name.
     * @param offset - first record on the page
     * @param maxResult - number of record on the page
     * @param roleName - name of role
     * @return - list of maxResult users bu role
     */
    List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName);

    /**
     * Determine number of users, which has specific role.
     * Role is determined by role name.
     * @param roleName - name of role
     * @return - number of users by role name
     */
    Long numberOfUsersByRole(String roleName);

    /**
     * Exclude a student from the university by his id.
     * @param userId - user Id
     */
    void deleteStudentById(Long userId);

    /**
     * Exclude a student from the university by his username.
     * @param username - username of user
     */
    void deleteStudentByUsername(String username);

}
