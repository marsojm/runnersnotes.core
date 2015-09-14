package fi.github.marsojm.runnersnotes.boundary;

import fi.github.marsojm.runnersnotes.core.interactors.EntityValidationException;

import java.util.List;

/**
 * Created by Marko on 7.9.2015.
 */
public interface NoteBoundary {
    NoteData getNote(GetNoteRequest request);
    int createNote(CreateNoteRequest request) throws EntityValidationException;
    List<NoteData> getNoteList(GetNoteListRequest request);
}
