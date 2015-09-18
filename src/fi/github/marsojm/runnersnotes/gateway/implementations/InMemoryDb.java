package fi.github.marsojm.runnersnotes.gateway.implementations;

import fi.github.marsojm.runnersnotes.boundary.NoteData;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.NoteGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Marko on 7.9.2015.
 */
public final class InMemoryDb implements NoteGateway<NoteData> {

    private static HashMap<Integer, NoteData> noteTable;

    public InMemoryDb() {
        this.noteTable = new HashMap<>();
    }

    @Override
    public NoteData getNote(int userId, int id) {
        return noteTable.getOrDefault(id, null);
    }

    @Override
    public List<NoteData> listNotes(int userId) {
        return noteTable.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void createNote(int userId, int id, NoteData note) throws InvalidIdException {
        if (noteTable.containsKey(id)) throw new InvalidIdException();
        noteTable.put(id, note);
    }
}
