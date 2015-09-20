package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.CreateUserRequest;
import fi.github.marsojm.runnersnotes.boundary.GetUserRequest;
import fi.github.marsojm.runnersnotes.boundary.UserData;
import fi.github.marsojm.runnersnotes.core.entities.User;
import fi.github.marsojm.runnersnotes.gateway.boundaries.UserGateway;
import fi.github.marsojm.runnersnotes.gateway.implementations.InMemoryDb;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marko on 20.9.2015.
 */
public class UserInteractorTest {

    private UserInteractor interactor;

    @Before
    public void setUp() throws Exception {
        interactor = new UserInteractor(new InMemoryDb());
    }

    @After
    public void tearDown() throws Exception {
        InMemoryDb.reset();
    }

    @Test
    public void testCreateUser() {
        CreateUserRequest request = new CreateUserRequest("abcd","abcdefgh");
        int id = interactor.createUser(request);
        assertEquals(1, id);
    }

    @Test
    public void testGetUser() {
        CreateUserRequest create = new CreateUserRequest("abcd","abcdefgh");
        int id = interactor.createUser(create);

        GetUserRequest request = new GetUserRequest(id);
        UserData user = interactor.getUser(request);

        assertEquals(create.getName(),user.getName());
        assertEquals(create.getPassword(),user.getPassword());
    }

    @Test
    public void testGetEmptyListOfUsers() {
        List<UserData> result = interactor.getUserList();
        assertEquals(0, result.size());
    }
}