package fi.github.marsojm.runnersnotes.boundary;

/**
 * Created by Marko on 18.9.2015.
 */
public class UserData {
    private int id;
    private String name;
    private String password;

    public UserData(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
