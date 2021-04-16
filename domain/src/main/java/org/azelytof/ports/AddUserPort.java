package org.azelytof.ports;

import org.azelytof.entities.UserEntity;

public interface AddUserPort {

    UserEntity addUser(String lastName, String firstName, String email);

}
