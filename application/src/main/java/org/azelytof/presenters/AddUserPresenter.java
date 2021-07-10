package org.azelytof.presenters;

import org.azelytof.boundary.OutputBoundary;
import org.azelytof.usecases.AddUserOutputMessage;
import org.azelytof.viewmodels.AddUserViewModel;

public class AddUserPresenter implements OutputBoundary<AddUserOutputMessage> {

    AddUserViewModel viewModel;

    @Override
    public void success(AddUserOutputMessage message) {
        viewModel = new AddUserViewModel(message.getUser());
    }

    @Override
    public void error(AddUserOutputMessage message, Exception error) {
        viewModel = new AddUserViewModel(message.getUser(), error);
    }

    public AddUserViewModel getViewModel() {
        return this.viewModel;
    }
}
