package by.kazarezov.dao;

import by.kazarezov.dao.exc.DaoConfException;

import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.util.Properties;

public class DaoProperties {
    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);

        try {
            if (propertiesFile == null) {
                throw new DaoConfException("Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
            }
        } catch (DaoConfException e) {
            e.printStackTrace();
        }

        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String specificKey;

    public DaoProperties(String specificKey) {
        this.specificKey = specificKey;
    }

    public String getProperty(String key) throws DaoConfException {
        String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null) {
            throw new DaoConfException("Required property '" + fullKey + "'"
                    + " is missing in properties file '" + PROPERTIES_FILE + "'.");
        }
        return property;
    }
}
