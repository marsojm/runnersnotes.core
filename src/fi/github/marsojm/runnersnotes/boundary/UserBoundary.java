package fi.github.marsojm.runnersnotes.boundary;

import java.util.List;

/**
 * Created by Marko on 20.9.2015.
 */
public interface UserBoundary {
    int createUser(CreateUserRequest request);
    List<UserData> getUserList();
    UserData getUser(GetUserRequest request);
}
