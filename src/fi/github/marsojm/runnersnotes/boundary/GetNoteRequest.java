package fi.github.marsojm.runnersnotes.boundary;

/**
 * Created by Marko on 7.9.2015.
 */
public class GetNoteRequest {
    private int id;

    public GetNoteRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
