package fi.github.marsojm.runnersnotes.gateway.boundaries;

import java.util.List;

/**
 * Created by Marko on 7.9.2015.
 */
public interface NoteGateway<T> {
    T getNote(int id);
    List<T> listNotes();
    void createNote(int id, T note) throws InvalidIdException;
}
