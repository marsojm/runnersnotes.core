package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.UserData;
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
    public void testGetEmptyListOfUsers() {
        List<UserData> result = interactor.getUserList();
        assertEquals(0, result.size());
    }
}