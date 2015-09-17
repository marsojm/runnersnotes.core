package fi.github.marsojm.runnersnotes.core.entities;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marko on 17.9.2015.
 */
public class UserTest {
    @Test
    public  void testCreateUser() throws Exception {
        User u = new User("abcd","abcdefgh");
    }

    @Test
    public  void testValidate() throws Exception {
        User u = new User("abcd","abcdefgh");
        List<String> errors = u.validate();
        assertEquals(0, errors.size());
    }

    @Test
    public  void testUserWithEmptyNameAndPassword() throws Exception {
        User u = new User("","");
        List<String> errors = u.validate();
        assertEquals(2, errors.size());
    }

    @Test
    public  void testUserWithShortNameAndShortPassword() throws Exception {
        User u = new User("abc","abcdefg");
        List<String> errors = u.validate();
        assertEquals(2, errors.size());
    }
}