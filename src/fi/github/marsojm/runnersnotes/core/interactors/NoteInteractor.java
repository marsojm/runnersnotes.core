package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.*;
import fi.github.marsojm.runnersnotes.core.entities.Note;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidParentIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.NoteGateway;

import java.util.List;

/**
 * Created by Marko on 7.9.2015.
 */
public class NoteInteractor implements NoteBoundary {

    private NoteGateway<NoteData> gateway;

    public NoteInteractor(NoteGateway<NoteData> gateway) {
        this.gateway = gateway;
    }

    @Override
    public NoteData getNote(GetNoteRequest request) {
        return gateway.getNote(request.getUserId(), request.getId());
    }

    @Override
    public int createNote(CreateNoteRequest request) throws EntityValidationException {
        Note note = new Note(request.getCreated(), request.getDistance(), request.getDuration(), request.getComments());
        List<String> errors = note.validate();
        int id = 0;
        if (errors.isEmpty()) {
            try {
                id = getNextId(request.getUserId());
                gateway.createNote(request.getUserId(), id, new NoteData(id, note.getCreated(), note.getDistance(), note.getDuration(), note.getComments()));
            } catch (InvalidIdException e) {
                e.printStackTrace();
            } catch (InvalidParentIdException e) {
                e.printStackTrace();
            }
        } else {
            throw new EntityValidationException(errors = errors);
        }

        return id;
    }

    @Override
    public List<NoteData> getNoteList(GetNoteListRequest request) {
        return gateway.listNotes(request.getUserId());
    }

    private int getNextId(int userId) {
        return gateway.listNotes(userId)
                .stream()
                .map(n -> n.getId())
                .reduce(0, (a, b) -> { if (a < b) return b; else return a; } ) + 1;
    }
}
