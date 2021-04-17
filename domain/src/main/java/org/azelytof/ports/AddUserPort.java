package org.azelytof.ports;

import org.azelytof.entities.UserEntity;
import org.azelytof.exceptions.AddUserException;

public interface AddUserPort {

    UserEntity addUser(String lastName, String firstName, String email) throws AddUserException;

}
