package by.it.milosh.dao;

import by.it.milosh.pojos.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {

    User findUserByUsername(String username);

    List<User> getAllUserByRole(String roleName);

    List<User> getAllUserByRolePagination(Integer offset, Integer maxResult, String roleName);

    Long numberOfUsersByRole(String roleName);

    List<User> getAllUsers();

}
