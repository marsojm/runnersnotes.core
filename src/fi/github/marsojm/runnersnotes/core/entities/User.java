package fi.github.marsojm.runnersnotes.core.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko on 17.9.2015.
 */
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<String> validate() {
        List<String> errors = new ArrayList<String>();
        if (this.name.isEmpty()) errors.add("Name is required!");
        else if (this.name.length() < 4) errors.add("Name must be at least 4 characters long!");

        if (this.password.isEmpty()) errors.add("Password is required!");
        else if (this.password.length() < 8) errors.add("Password must be at least 8 characters long!");

        return errors;
    }
}
