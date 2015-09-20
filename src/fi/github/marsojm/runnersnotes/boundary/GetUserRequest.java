package fi.github.marsojm.runnersnotes.boundary;

/**
 * Created by Marko on 20.9.2015.
 */
public class GetUserRequest {
    private int userId;

    public GetUserRequest(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}
