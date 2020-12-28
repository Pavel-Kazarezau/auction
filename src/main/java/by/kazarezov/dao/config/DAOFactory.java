package by.kazarezov.dao.config;

import by.kazarezov.dao.UserDAO;
import by.kazarezov.dao.impl.UserDAOJBDC;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DAOFactory {
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_DRIVER = "driver";
    public static final String PROPERTY_USERNAME = "username";
    public static final String PROPERTY_PASSWORD = "password";

    public static DAOFactory getInstance(String name) throws DAOConfigurationException {
        if (name == null) {
            throw new DAOConfigurationException("Database name is null");
        }

        DAOProperties properties = new DAOProperties(name);
        String url = properties.getProperty(PROPERTY_URL, true);
        String driveClassName = properties.getProperty(PROPERTY_DRIVER, false);
        String password = properties.getProperty(PROPERTY_PASSWORD, false);
        String username = properties.getProperty(PROPERTY_USERNAME, password != null);
        DAOFactory instance;

        if (driveClassName != null) {
            try {
                Class.forName(driveClassName);
            } catch (ClassNotFoundException e) {
                throw new DAOConfigurationException("Driver class '" + driveClassName +
                        "' is missing in the classpath");
            }
            instance = new DriverManagerDAOFactory(url, username, password);
        } else {
            DataSource dataSource;
            try {
                dataSource = (DataSource) new InitialContext().lookup(url);
            } catch (NamingException e) {
               throw new DAOConfigurationException(
                       "DataSource '" + url + "' is missing.", e);
            }
            if (username != null) {
                instance = new DataSourceWithLoginDAOFactory(dataSource, username, password);
            } else {
                instance = new DataSourceDAOFactory(dataSource);
            }
        }
        return instance;
    }

    public abstract Connection getConnection() throws SQLException;

    public UserDAO getUserDAO() {
        return new UserDAOJBDC(this);
    }
}
