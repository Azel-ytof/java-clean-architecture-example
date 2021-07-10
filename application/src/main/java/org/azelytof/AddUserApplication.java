package org.azelytof;

import org.azelytof.ports.AddUserPort;
import org.azelytof.presenters.AddUserPresenter;
import org.azelytof.repositories.FileRepository;
import org.azelytof.usecases.AddUserInputMessage;
import org.azelytof.usecases.AddUserInteractor;
import org.azelytof.viewmodels.AddUserViewModel;

public class AddUserApplication implements Runnable {

    AddUserPresenter presenter;
    AddUserInputMessage inputMessage;
    AddUserInteractor interactor;
    AddUserViewModel viewModel;

    public AddUserApplication(String filePath, String lastName, String firstName, String email) {
        AddUserPort repository = new FileRepository(filePath);
        this.presenter = new AddUserPresenter();
        this.inputMessage = new AddUserInputMessage(lastName, firstName, email);
        this.interactor = new AddUserInteractor(repository, presenter);
    }

    @Override
    public void run() {
        interactor.execute(inputMessage);

        this.viewModel = presenter.getViewModel();

        if (this.viewModel.isError()) {
            String errorMessage = String.format("An error occurred during application execution : %s", this.viewModel.getError());
            System.err.println(errorMessage);
            return;
        }

        String successMessage = String.format("Application execution successful with user : %s", viewModel.getUser());
        System.out.println(successMessage);
    }

    public boolean isExecutionError() throws InstantiationException {
        if (this.viewModel == null) {
            throw new InstantiationException("The application is not running yet");
        }

        return this.viewModel.isError();
    }

}
