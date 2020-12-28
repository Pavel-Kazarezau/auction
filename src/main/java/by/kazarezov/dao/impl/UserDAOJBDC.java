package by.kazarezov.dao.impl;

import by.kazarezov.bean.User;
import by.kazarezov.dao.DAOUtil;
import by.kazarezov.dao.UserDAO;
import by.kazarezov.dao.config.DAOException;
import by.kazarezov.dao.config.DAOFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class UserDAOJBDC implements UserDAO {
    private final String TABLE_NAME = "users";
    private final String FIND_BY_ID =
            "SELECT * FROM " + TABLE_NAME + " WHERE id =?;";
    private final String FIND_BY_EMAIL_N_PASSWORD =
            "SELECT * FROM " + TABLE_NAME + " WHERE username = ? AND password = ?;";
    private final String LIST_ORDER_BY_ID =
            "SELECT * FROM " + TABLE_NAME + " ORDER BY id;";
    private final String INSERT =
            "INSERT INTO " + TABLE_NAME + " VALUES (unix_timestamp(now() + 1000000000), ?, ?, ?, ?, ?, NOW());";
    /*private final String UPDATE =
            "UPDATE " + TABLE_NAME + " SET email=?, fName=?, ";*/
    private final String EXIST_MAIL =
            "SELECT * FROM " + TABLE_NAME + " WHERE email = ?;";

    private final String CHANGE_PASSWORD =
            "UPDATE " + TABLE_NAME + " SET password MD5(?) WHERE id = ?;";

    private final String DELETE =
            "DELETE FROM " + TABLE_NAME + " WHERE id = ?;";

    private DAOFactory daoFactory;

    public UserDAOJBDC(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public User find(int id) throws DAOException {
        return find(FIND_BY_ID, id);
    }

    @Override
    public User find(String email, String password) throws DAOException {
        return find(FIND_BY_EMAIL_N_PASSWORD, email, password);
    }

    public User find(String sql, Object... values) throws DAOException {
        User user = null;

        try {
            Connection connection = daoFactory.getConnection();
            PreparedStatement statement = DAOUtil.preparedStatement(connection, sql, false, values);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = map(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
        return user;
    }


    @Override
    public List<User> list() throws DAOException {
        return null;
    }

    @Override
    public void create(User user) throws IllegalArgumentException {
        if (user.getId() != 0) {
            throw new IllegalArgumentException("User is already created, the user ID is not null.");
        }

    }

    @Override
    public void update(User user) throws DAOException {

    }

    @Override
    public boolean existEmail(String email) throws DAOException {
        return false;
    }

    @Override
    public void changePassword(String password) throws DAOException {

    }

    @Override
    public void delete(User user) throws DAOException {

    }

    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setfName(resultSet.getString("fname"));
        user.setlName(resultSet.getString("lname"));
        user.setPhoneNumber(resultSet.getString("phone_num"));
        user.setDateOfRegistration(resultSet.getTimestamp("date_of_registration").toLocalDateTime());
        return user;
    }
 }
