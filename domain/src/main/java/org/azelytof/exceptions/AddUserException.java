package org.azelytof.exceptions;

public class AddUserException extends Exception {

    final String baseMessage = "A problem occurred while adding a new user";

    public AddUserException() {
    }

    public AddUserException(String message) {
        super(message);
    }

    public AddUserException(Throwable cause) {
        super(cause);
    }

    public AddUserException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        if (super.getMessage() == null || super.getMessage().isEmpty()) {
            return baseMessage;
        }
        return String.format("%s : %s", baseMessage, super.getMessage());
    }
}
