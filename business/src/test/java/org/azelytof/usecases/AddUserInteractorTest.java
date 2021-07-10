package org.azelytof.usecases;

import org.azelytof.boundary.OutputBoundary;
import org.azelytof.entities.UserEntity;
import org.azelytof.exceptions.AddUserException;
import org.azelytof.ports.AddUserPort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class AddUserInteractorTest {

    AddUserInteractor cut;
    AddUserPort mockedAddUserPort;
    AddUserOutputMessage outputMessage;
    OutputBoundary<AddUserOutputMessage> mockedPresenter;

    @Before
    public void setUp() {
        mockedAddUserPort = mock(AddUserPort.class);
        mockedPresenter = mock(OutputBoundary.class);

        outputMessage = new AddUserOutputMessage();

        cut = new AddUserInteractor(mockedAddUserPort, mockedPresenter);
        cut.outputMessage = outputMessage;
    }

    @Test
    public void executeTestAddUserException() throws AddUserException {
        String lastName = "Last Name Test";
        String firstName = "First Name Test";
        String email = "Email Test";
        AddUserException addUserException = new AddUserException();
        doThrow(addUserException).when(mockedAddUserPort).addUser(eq(lastName), eq(firstName), eq(email));

        cut.execute(new AddUserInputMessage(lastName, firstName, email));

        assertNull(outputMessage.getUser());

        verify(mockedPresenter, times(1)).error(eq(outputMessage), eq(addUserException));
        verify(mockedPresenter, times(0)).success(eq(outputMessage));
    }

    @Test
    public void executeTest() throws AddUserException {
        String lastName = "Last Name Test";
        String firstName = "First Name Test";
        String email = "Email Test";
        UserEntity user = new UserEntity(lastName, firstName, email);
        doReturn(user).when(mockedAddUserPort).addUser(eq(lastName), eq(firstName), eq(email));

        cut.execute(new AddUserInputMessage(lastName, firstName, email));

        assertEquals(user, outputMessage.getUser());

        verify(mockedPresenter, times(0)).error(eq(outputMessage), any(AddUserException.class));
        verify(mockedPresenter, times(1)).success(eq(outputMessage));
    }

}
