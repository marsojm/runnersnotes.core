package fi.github.marsojm.runnersnotes.gateway.boundaries;

import fi.github.marsojm.runnersnotes.boundary.NoteData;
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

    @Before
    public void setUp() {
        gateway = new InMemoryDb();
    }

    @Test
    public void testGetNote() throws Exception {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, data);

        NoteData actual = gateway.getNote(0, id);
        assertEquals(data, actual);
    }

    @Test
    public void testCreateNote() throws Exception {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, data);
    }

    @Test
    public void testListNotes() throws Exception {
        NoteData data = TestDataGenerator.GenerateNoteData(rnd.nextInt());
        gateway.createNote(0, data.getId(), data);
        NoteData data2 = TestDataGenerator.GenerateNoteData(rnd.nextInt());
        gateway.createNote(0, data2.getId(), data2);

        List<NoteData> result = gateway.listNotes(0);
        assertEquals(2, result.size());
    }

    @Test(expected = InvalidIdException.class)
    public void testCreateNoteWithDuplicateId() throws Exception {
        int id = rnd.nextInt();
        NoteData data = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, data);

        NoteData duplicate = TestDataGenerator.GenerateNoteData(id);
        gateway.createNote(0, id, duplicate);
    }

}