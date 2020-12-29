package by.kazarezov.dao;

import by.kazarezov.bean.User;
import by.kazarezov.dao.exc.DaoException;

import java.util.List;

public interface UserDao {

    User find(int id) throws DaoException;

    User find(String email, String password) throws DaoException;

    void create(User user) throws DaoException;

    void update(User user) throws DaoException;

    void delete(User user) throws DaoException;

    boolean existEmail(String email) throws DaoException;

}
