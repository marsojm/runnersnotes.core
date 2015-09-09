package fi.github.marsojm.runnersnotes.boundary;

import java.util.List;

/**
 * Created by Marko on 7.9.2015.
 */
public interface NoteBoundary {
    NoteData getNote(GetNoteRequest request);
    int createNote(CreateNoteRequest request);
    List<NoteData> getNoteList(GetNoteListRequest request);
}
