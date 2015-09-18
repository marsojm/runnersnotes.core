package fi.github.marsojm.runnersnotes.gateway.boundaries;

import fi.github.marsojm.runnersnotes.boundary.NoteData;
import fi.github.marsojm.runnersnotes.gateway.implementations.InMemoryDb;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by Marko on 8.9.2015.
 */
public class NoteGatewayTest {

    private NoteGateway<NoteData> gateway;

    @Before
    public void setUp() {
        gateway = new InMemoryDb();
    }

    @Test
    public void testGetNote() throws Exception {
        int id = new Random().nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, data);

        NoteData actual = gateway.getNote(0, id);
        assertEquals(data, actual);
    }

    @Test
    public void testCreateNote() throws Exception {
        int id = new Random().nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, data);
    }

    @Test(expected = InvalidIdException.class)
    public void testCreateNoteWithDuplicateId() throws Exception {
        int id = new Random().nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, data);

        NoteData duplicate = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, duplicate);
    }

}