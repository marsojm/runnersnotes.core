package fi.github.marsojm.runnersnotes.boundary;

/**
 * Created by Marko on 9.9.2015.
 */
public class GetNoteListRequest {
    private int userId;

    public GetNoteListRequest(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
