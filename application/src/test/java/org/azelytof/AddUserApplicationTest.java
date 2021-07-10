package org.azelytof;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class AddUserApplicationTest {

    AddUserApplication cut;

    @Test
    public void runTest() throws InstantiationException {
        String filePath = "src/test/resources/tmp/tmp_file_test.csv";
        String lastName = "Last Name Test";
        String firstName = "First Name Test";
        String email = "Email Test";
        cut = new AddUserApplication(filePath, lastName, firstName, email);

        cut.run();

        assertFalse(cut.isExecutionError());
    }

}
