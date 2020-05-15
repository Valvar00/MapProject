package pl.valvar.dao;

import pl.valvar.models.User;

import java.util.List;

public interface UsersDao extends CrudDao<User> {
    List<User> findAllByFirstName(String firstName);
    int insertUser(String name,String password, String email);
}
