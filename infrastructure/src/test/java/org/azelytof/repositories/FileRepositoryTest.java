package org.azelytof.repositories;

import org.azelytof.entities.UserEntity;
import org.azelytof.exceptions.AddUserException;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileRepositoryTest {

    FileRepository cut;

    @Test
    public void addUserTest() throws AddUserException, IOException {
        String filePath = "src/test/resources/tmp/tmp_file_test.csv";
        cut = new FileRepository(filePath);

        String lastName = "Last Name Example";
        String firstName = "First Name Example";
        String email = "email@example.com";
        UserEntity actual = cut.addUser(lastName, firstName, email);

        assertEquals(lastName, actual.getLastName());
        assertEquals(firstName, actual.getFirstName());
        assertEquals(email, actual.getEmail());

        Path expectedFilePath = Paths.get(filePath);
        assertTrue(Files.exists(expectedFilePath));
        List<String> actualContent = Files.readAllLines(expectedFilePath);
        assertEquals(1, actualContent.size());
        assertEquals(String.format("%s;%s;%s", lastName, firstName, email), actualContent.get(0));
    }

}
