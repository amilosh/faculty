package by.it.milosh.exceptions;

import java.io.Serializable;

/**
 * A class describes wrapper for exceptions in DAO layer.
 */

public class DAOException extends Exception implements Serializable {

    private static final long serialVersionUID = 5L;

    private Exception exception;

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
