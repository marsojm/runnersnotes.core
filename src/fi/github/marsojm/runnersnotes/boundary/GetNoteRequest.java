package fi.github.marsojm.runnersnotes.boundary;

/**
 * Created by Marko on 7.9.2015.
 */
public class GetNoteRequest {
    private int id;
    private int userId;

    public GetNoteRequest(int userId, int id) {
        this.id = id;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}
