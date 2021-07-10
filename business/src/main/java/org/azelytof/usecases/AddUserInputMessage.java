package org.azelytof.usecases;

import org.azelytof.boundary.InputMessage;

public class AddUserInputMessage implements InputMessage {
    String lastName;
    String firstName;
    String email;

    public AddUserInputMessage(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

}
