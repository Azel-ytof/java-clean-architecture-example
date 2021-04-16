package org.azelytof.exceptions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class AddUserExceptionTest {

    AddUserException cut;

    @Test
    public void emptyConstructorTest() {
        cut = new AddUserException();

        assertEquals(cut.baseMessage, cut.getMessage());
        assertNull(cut.getCause());
    }

    @Test
    public void messageConstructorTest() {
        String message = "Add User Exception Test";

        cut = new AddUserException(message);

        assertEquals(String.format("%s : %s", cut.baseMessage, message), cut.getMessage());
        assertNull(cut.getCause());
    }

    @Test
    public void throwableConstructorTest() {
        String message = "Add User Exception Test";
        Exception exception = new Exception(message);

        cut = new AddUserException(exception);

        assertEquals(String.format("%s : %s", cut.baseMessage, exception), cut.getMessage());
        assertEquals(exception, cut.getCause());
    }

    @Test
    public void messageAndThrowableConstructorTest() {
        String message = "Add User Exception Test";
        Exception exception = new Exception(message);

        cut = new AddUserException(message, exception);

        assertEquals(String.format("%s : %s", cut.baseMessage, message), cut.getMessage());
        assertEquals(exception, cut.getCause());
    }
}
