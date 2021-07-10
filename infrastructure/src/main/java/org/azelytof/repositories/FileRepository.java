package org.azelytof.repositories;

import org.azelytof.entities.UserEntity;
import org.azelytof.exceptions.AddUserException;
import org.azelytof.ports.AddUserPort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRepository implements AddUserPort {
    Path filePath;

    public FileRepository(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    @Override
    public UserEntity addUser(String lastName, String firstName, String email) throws AddUserException {
        String content = String.format("%s;%s;%s", lastName, firstName, email);

        createParentDirectories();
        createFile();

        try {
            Files.writeString(filePath, content);
        } catch (IOException e) {
            String errorMessage = String.format("An error occured while puting content '%s' in file %s", content, filePath);
            throw new AddUserException(errorMessage, e);
        }

        return new UserEntity(lastName, firstName, email);
    }

    public void createParentDirectories() throws AddUserException {
        Path parents = filePath.getParent();

        if (parents == null || Files.exists(parents)) {
            System.out.println("No parents directories to create");
            return;
        }

        try {
            Files.createDirectories(parents);
        } catch (IOException e) {
            String errorMessage = String.format("An error occured while creating directories %s", parents);
            throw new AddUserException(errorMessage, e);
        }
    }

    public void createFile() throws AddUserException {
        if (Files.exists(filePath)) {
            return;
        }

        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            String errorMessage = String.format("An error occured while creating file %s", filePath);
            throw new AddUserException(errorMessage, e);
        }
    }
}