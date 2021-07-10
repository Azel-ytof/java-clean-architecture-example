package org.azelytof.usecases;

import org.azelytof.boundary.OutputMessage;
import org.azelytof.entities.UserEntity;

public class AddUserOutputMessage implements OutputMessage {

    UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

}
