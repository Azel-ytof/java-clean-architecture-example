package org.azelytof.entities;

public class UserEntity {
    String lastName;
    String firstName;
    String email;

    public UserEntity(String lastName, String firstName, String email) {
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

    @Override
    public String toString() {
        return String.format("{ Last name = %s ; First name = %s ; Email = %s }", lastName, firstName, email);
    }
}
