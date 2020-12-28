package by.kazarezov.dao;

import by.kazarezov.bean.User;
import by.kazarezov.dao.config.DAOException;

import java.util.List;

public interface UserDAO {

    public User find(int id) throws DAOException;

    public User find(String email, String password) throws DAOException;

    public List<User> list() throws DAOException;

    public void create(User user) throws DAOException;

    public void update(User user) throws DAOException;

    public void delete(User user) throws DAOException;

    public boolean existEmail(String email) throws DAOException;

    public void changePassword(String password) throws DAOException;
}
