package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.*;
import fi.github.marsojm.runnersnotes.core.entities.Note;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.NoteGateway;

import java.util.List;

/**
 * Created by Marko on 7.9.2015.
 */
public class NotesInteractor implements NoteBoundary {

    private NoteGateway<NoteData> gateway;

    public NotesInteractor(NoteGateway<NoteData> gateway) {
        this.gateway = gateway;
    }

    @Override
    public NoteData getNote(GetNoteRequest request) {
        return gateway.getNote(request.getId());
    }

    @Override
    public int createNote(CreateNoteRequest request) {
        Note note = new Note(request.getCreated(), request.getDistance(), request.getDuration(), request.getComments());
        List<String> errors = note.validate();
        int id = 0;
        if (errors.isEmpty()) {
            try {
                id = getNextId();
                gateway.createNote(id, new NoteData(id, note.getCreated(), note.getDistance(), note.getDuration(), note.getComments()));
            } catch (InvalidIdException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    @Override
    public List<NoteData> getNoteList(GetNoteListRequest request) {
        return gateway.listNotes();
    }

    private int getNextId() {
        return gateway.listNotes()
                .stream()
                .map(n -> n.getId())
                .reduce(0, (a, b) -> { if (a < b) return b; else return a; } ) + 1;
    }
}
