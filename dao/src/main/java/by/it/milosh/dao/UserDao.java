package by.it.milosh.dao;

import by.it.milosh.pojos.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    /**
     * Extrsct one user from DB by username.
     * @param username - name of user
     * @return - user by username
     */
    User findUserByUsername(String username);

    /**
     * Extract all users, which have specific role.
     * Role is determined by role name.
     * @param roleName - name of role
     * @return - list of all users, who have this role
     */
    List<User> getAllUserByRole(String roleName);

    /**
     * Extract all users, which has specific role, using pagination.
     * Role is determined by role name.
     * @param offset - first record on the page
     * @param maxResult - number of record on the page
     * @param roleName - name of role
     * @return - list of users, who have this role, using pagination
     */
    List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName);

    /**
     * Determine number of users, which has specific role.
     * Role is determined by role name.
     * @param roleName - name of role
     * @return - number of user, who have this role
     */
    Long numberOfUsersByRole(String roleName);

    /**
     * Extract all Users from DB.
     * @return - list of all users
     */
    List<User> getAllUsers();

    /**
     * Exclude a student from the university by his id.
     * @param userId - user Id
     */
    void deleteStudentById(Long userId);

}
