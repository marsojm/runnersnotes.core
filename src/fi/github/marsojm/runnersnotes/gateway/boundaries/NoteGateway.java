package fi.github.marsojm.runnersnotes.gateway.boundaries;

import java.util.List;

/**
 * Created by Marko on 7.9.2015.
 */
public interface NoteGateway<T> {
    T getNote(int userId, int id);
    List<T> listNotes(int userId);
    void createNote(int userId, int id, T note) throws InvalidIdException;
}
