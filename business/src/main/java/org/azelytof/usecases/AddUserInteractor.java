package org.azelytof.usecases;

import org.azelytof.boundary.InputBoundary;
import org.azelytof.boundary.OutputBoundary;
import org.azelytof.entities.UserEntity;
import org.azelytof.exceptions.AddUserException;
import org.azelytof.ports.AddUserPort;

public class AddUserInteractor implements InputBoundary<AddUserInputMessage> {

    AddUserPort addUserPort;
    AddUserOutputMessage outputMessage;
    OutputBoundary<AddUserOutputMessage> presenter;

    public AddUserInteractor(AddUserPort addUserPort, OutputBoundary<AddUserOutputMessage> presenter) {
        this.addUserPort = addUserPort;
        this.presenter = presenter;
        this.outputMessage = new AddUserOutputMessage();
    }

    @Override
    public void execute(AddUserInputMessage message) {
        UserEntity user;
        try {
            user = addUserPort.addUser(message.getLastName(), message.getFirstName(), message.getEmail());
        } catch (AddUserException e) {
            presenter.error(this.outputMessage, e);
            return;
        }

        this.outputMessage.setUser(user);

        presenter.success(this.outputMessage);
    }

}
