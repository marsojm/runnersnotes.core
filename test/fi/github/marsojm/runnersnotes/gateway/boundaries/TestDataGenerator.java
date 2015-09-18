package fi.github.marsojm.runnersnotes.gateway.boundaries;

import fi.github.marsojm.runnersnotes.boundary.NoteData;
import fi.github.marsojm.runnersnotes.boundary.UserData;

import java.util.Date;
import java.util.Random;

/**
 * Created by Marko on 8.9.2015.
 */
public class TestDataGenerator {

    public static NoteData GenerateNoteData(int id) {
        Random r = new Random();
        return new NoteData(id, new Date(), r.nextFloat(), r.nextInt(), "");
    }

    public static UserData GenerateUserData(int id) {
        return new UserData(id, "","");
    }
}
