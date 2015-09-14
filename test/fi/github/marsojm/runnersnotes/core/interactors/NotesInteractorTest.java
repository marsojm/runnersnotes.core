package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.CreateNoteRequest;
import fi.github.marsojm.runnersnotes.boundary.GetNoteListRequest;
import fi.github.marsojm.runnersnotes.boundary.GetNoteRequest;
import fi.github.marsojm.runnersnotes.boundary.NoteData;
import fi.github.marsojm.runnersnotes.gateway.implementations.InMemoryDb;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marko on 7.9.2015.
 */
public class NotesInteractorTest {

    private NotesInteractor interactor;

    @Before
    public void setUp() {
        interactor = new NotesInteractor(new InMemoryDb());
    }

    @Test
    public void testGetNote() throws Exception, EntityValidationException {
        int id = interactor.createNote(new CreateNoteRequest(new Date(), 10, 20, "no comments"));
        NoteData response = interactor.getNote(new GetNoteRequest(id));
        assertNotNull(response);
    }

    @Test
    public void testGetEmptyListOfNotes() throws Exception {
        List<NoteData> notes = interactor.getNoteList(new GetNoteListRequest());
        assertEquals(0, notes.size());
    }

    @Test
    public void testGetListOfNotes() throws Exception, EntityValidationException {
        interactor.createNote(new CreateNoteRequest(new Date(), 10, 20, "no comments"));
        interactor.createNote(new CreateNoteRequest(new Date(), 10, 20, "no comments"));
        interactor.createNote(new CreateNoteRequest(new Date(), 10, 20, "no comments"));

        List<NoteData> notes = interactor.getNoteList(new GetNoteListRequest());
        assertEquals(3, notes.size());
    }

    @Test
    public void testGetNoteWhenMultipleNotesExists() throws Exception, EntityValidationException {
        interactor.createNote(new CreateNoteRequest(new Date(), 10, 20, "no comments"));
        int id = interactor.createNote(new CreateNoteRequest(new Date(), 15, 30, "many comments"));
        NoteData response = interactor.getNote(new GetNoteRequest(id));
        assertNotNull(response);
    }
}