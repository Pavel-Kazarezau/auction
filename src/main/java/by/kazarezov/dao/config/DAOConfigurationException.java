package by.kazarezov.dao.config;

public class DAOConfigurationException extends Exception{
    public DAOConfigurationException() {
        super();
    }

    public DAOConfigurationException(String message) {
        super(message);
    }

    public DAOConfigurationException(String message, Exception cause) {
        super(message, cause);
    }

    public DAOConfigurationException(Exception cause) {
        super(cause);
    }
}
