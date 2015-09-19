package fi.github.marsojm.runnersnotes.gateway.boundaries;

import fi.github.marsojm.runnersnotes.boundary.NoteData;
import fi.github.marsojm.runnersnotes.boundary.UserData;
import fi.github.marsojm.runnersnotes.gateway.implementations.InMemoryDb;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Marko on 8.9.2015.
 */
public class NoteGatewayTest {

    private NoteGateway<NoteData> gateway;
    private Random rnd = new Random();
    private int userId;

    @Before
    public void setUp() {
        gateway = new InMemoryDb();
        try {
            UserData user = TestDataGenerator.GenerateUserData(rnd.nextInt());
            userId = user.getId();
            ((UserGateway<UserData>)gateway).createUser(userId,user);
        } catch (Exception e) {

        }
    }

    @Test
    public void testGetNote() throws Exception, InvalidParentIdException {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(userId, id, data);

        NoteData actual = gateway.getNote(userId, id);
        assertEquals(data, actual);
    }

    @Test
    public void testCreateNote() throws Exception, InvalidParentIdException {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(userId, id, data);
    }

    @Test(expected = InvalidParentIdException.class)
    public void testCreateNoteWithoutExistingUser() throws Exception, InvalidParentIdException {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(userId+1, id, data);
    }

    @Test
    public void testListNotes() throws Exception, InvalidParentIdException {
        NoteData data = TestDataGenerator.GenerateNoteData(rnd.nextInt());
        gateway.createNote(userId, data.getId(), data);
        NoteData data2 = TestDataGenerator.GenerateNoteData(rnd.nextInt());
        gateway.createNote(userId, data2.getId(), data2);

        List<NoteData> result = gateway.listNotes(userId);
        assertEquals(2, result.size());
    }

    @Test(expected = InvalidIdException.class)
    public void testCreateNoteWithDuplicateId() throws Exception, InvalidParentIdException {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(userId, id, data);

        NoteData duplicate = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(userId, id, duplicate);
    }

}