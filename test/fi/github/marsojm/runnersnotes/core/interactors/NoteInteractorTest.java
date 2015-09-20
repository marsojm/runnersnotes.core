package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.*;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.UserGateway;
import fi.github.marsojm.runnersnotes.gateway.implementations.InMemoryDb;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marko on 7.9.2015.
 */
public class NoteInteractorTest {

    private NoteInteractor interactor;
    private int userId = 1;

    @Before
    public void setUp() throws InvalidIdException {
        InMemoryDb.reset();
        UserGateway<UserData> gateway = new InMemoryDb();
        gateway.createUser(userId, new UserData(userId, "", ""));
        interactor = new NoteInteractor(new InMemoryDb());
    }

    @Test
    public void testGetNote() throws Exception, EntityValidationException {
        int id = interactor.createNote(new CreateNoteRequest(userId, new Date(), 10, 20, "no comments"));
        NoteData response = interactor.getNote(new GetNoteRequest(userId,id));
        assertNotNull(response);
    }

    @Test
    public void testGetEmptyListOfNotes() throws Exception {
        List<NoteData> notes = interactor.getNoteList(new GetNoteListRequest(userId));
        assertEquals(0, notes.size());
    }

    @Test
    public void testGetListOfNotes() throws Exception, EntityValidationException {
        interactor.createNote(new CreateNoteRequest(userId, new Date(), 10, 20, "no comments"));
        interactor.createNote(new CreateNoteRequest(userId, new Date(), 10, 20, "no comments"));
        interactor.createNote(new CreateNoteRequest(userId, new Date(), 10, 20, "no comments"));

        List<NoteData> notes = interactor.getNoteList(new GetNoteListRequest(userId));
        assertEquals(3, notes.size());
    }

    @Test
    public void testGetNoteWhenMultipleNotesExists() throws Exception, EntityValidationException {
        interactor.createNote(new CreateNoteRequest(userId, new Date(), 10, 20, "no comments"));
        int id = interactor.createNote(new CreateNoteRequest(userId,new Date(), 15, 30, "many comments"));
        NoteData response = interactor.getNote(new GetNoteRequest(userId,id));
        assertNotNull(response);
    }

    @Test
    public void testValidationErrors() {
        try {
            interactor.createNote(new CreateNoteRequest(userId, null, -10, -20, "no comments"));
        } catch (EntityValidationException e) {
            assertEquals(3, e.getErrors().size());
        }
    }
}