package fi.github.marsojm.runnersnotes.gateway.implementations;

import fi.github.marsojm.runnersnotes.boundary.NoteData;
import fi.github.marsojm.runnersnotes.boundary.UserData;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidParentIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.NoteGateway;
import fi.github.marsojm.runnersnotes.gateway.boundaries.UserGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Marko on 7.9.2015.
 */
public final class InMemoryDb implements NoteGateway<NoteData>, UserGateway<UserData> {

    class KeyPair {
        private final int key1;
        private final int key2;
        public KeyPair(int key1, int key2) {
            this.key1 = key1;
            this.key2 = key2;
        }

        public int getKey1() {
            return key1;
        }

        public int getKey2() {
            return key2;
        }

        @Override
        public int hashCode() {
            return this.key1 * 10000 + this.key2 * 100;
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof KeyPair) {
                KeyPair o = (KeyPair)other;
                return  o.getKey1() == this.key1 && o.getKey2() == this.key2;
            }
            return false;
        }
    }

    private static HashMap<KeyPair, NoteData> noteTable;
    private static HashMap<Integer, UserData> userTable;

    public InMemoryDb() {
        this.noteTable = new HashMap<>();
        this.userTable = new HashMap<>();
    }

    @Override
    public NoteData getNote(int userId, int id) {
        return noteTable.getOrDefault(new KeyPair(userId,id), null);
    }

    @Override
    public List<NoteData> listNotes(int userId) {
        return noteTable.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void createNote(int userId, int id, NoteData note) throws InvalidIdException, InvalidParentIdException {
        if (!userTable.containsKey(userId)) throw new InvalidParentIdException();
        if (noteTable.containsKey(new KeyPair(userId,id))) throw new InvalidIdException();
        noteTable.put(new KeyPair(userId,id), note);
    }

    @Override
    public UserData getUser(int userId) {
        return userTable.getOrDefault(userId, null);
    }

    @Override
    public List<UserData> listUsers() {
        return userTable.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public void createUser(int userId, UserData user) throws InvalidIdException {
        if (userTable.containsKey(userId)) throw new InvalidIdException();
        userTable.put(userId, user);
    }
}
