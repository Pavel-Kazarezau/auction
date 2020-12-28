package by.kazarezov.dao.config;

import by.kazarezov.dao.config.DAOConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DAOProperties {
    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        if (propertiesFile == null) {
            try {
                throw new DAOConfigurationException(
                        "Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
            } catch (DAOConfigurationException e) {
                e.printStackTrace();
            }
        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            try {
                throw new DAOConfigurationException(
                        "Cannot load properties file '" + PROPERTIES_FILE + "'.", e);
            } catch (DAOConfigurationException daoConfigurationException) {
                daoConfigurationException.printStackTrace();
            }
        }
    }

    private String specificKey;

    public DAOProperties(String specificKey) throws DAOConfigurationException{
        this.specificKey = specificKey;
    }

    public String getProperty(String key, boolean mandatory) throws DAOConfigurationException{
        String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
            if (mandatory) {
                throw new DAOConfigurationException("Required property '" + property +
                        "' is missing in properties file '" + PROPERTIES_FILE + "'.");
            } else {
                property = null;
            }
        }
        return property;
    }
}
