package fi.github.marsojm.runnersnotes.gateway.boundaries;

import fi.github.marsojm.runnersnotes.boundary.UserData;
import fi.github.marsojm.runnersnotes.gateway.implementations.InMemoryDb;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Marko on 18.9.2015.
 */
public class UserGatewayTest {

    private UserGateway<UserData> gateway;
    private Random rnd = new Random();

    @Before
    public void setUp() {
        gateway = new InMemoryDb();
    }

    @Test
    public void testGetUser() throws Exception {
        int id = rnd.nextInt();
        UserData data = TestDataGenerator.GenerateUserData(id);
        gateway.createUser(id, data);

        UserData actual = gateway.getUser(id);
        assertEquals(data, actual);
    }

    @Test
    public void testListUsers() throws Exception {
        UserData data = TestDataGenerator.GenerateUserData(rnd.nextInt());
        gateway.createUser(data.getId(), data);
        UserData data2 = TestDataGenerator.GenerateUserData(rnd.nextInt());
        gateway.createUser(data2.getId(), data2);

        List<UserData> result = gateway.listUsers();
        assertEquals(2, result.size());
    }

    @Test
    public void testCreateUser() throws Exception {
        int id = new Random().nextInt();
        UserData data = TestDataGenerator.GenerateUserData(id);
        gateway.createUser(id, data);
    }
}