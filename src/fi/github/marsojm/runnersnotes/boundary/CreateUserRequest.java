package fi.github.marsojm.runnersnotes.boundary;

/**
 * Created by Marko on 20.9.2015.
 */
public class CreateUserRequest {
    private final String name;
    private final String password;

    public CreateUserRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
