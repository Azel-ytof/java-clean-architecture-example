package org.azelytof.viewmodels;

import org.azelytof.entities.UserEntity;

public class AddUserViewModel {

    UserEntity user;
    Exception error;

    public AddUserViewModel(UserEntity user) {
        this.user = user;
    }

    public AddUserViewModel(UserEntity user, Exception error) {
        this.user = user;
        this.error = error;
    }

    public boolean isSuccess() {
        return this.error == null;
    }

    public boolean isError() {
        return !isSuccess();
    }

    public UserEntity getUser() {
        return user;
    }

    public Exception getError() {
        return error;
    }
}
