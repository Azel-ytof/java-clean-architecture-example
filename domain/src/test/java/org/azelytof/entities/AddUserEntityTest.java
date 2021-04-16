package org.azelytof.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddUserEntityTest {

    UserEntity cut;

    @Test
    public void constructorTest() {
        String lastName = "Last Name Test";
        String firstName = "First Name Test";
        String email = "Email Test";

        cut = new UserEntity(lastName, firstName, email);

        assertEquals(lastName, cut.getLastName());
        assertEquals(firstName, cut.getFirstName());
        assertEquals(email, cut.getEmail());
    }

}
