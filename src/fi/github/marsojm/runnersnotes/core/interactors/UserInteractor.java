package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.CreateUserRequest;
import fi.github.marsojm.runnersnotes.boundary.UserBoundary;
import fi.github.marsojm.runnersnotes.boundary.UserData;
import fi.github.marsojm.runnersnotes.core.entities.User;
import fi.github.marsojm.runnersnotes.gateway.boundaries.InvalidIdException;
import fi.github.marsojm.runnersnotes.gateway.boundaries.UserGateway;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko on 20.9.2015.
 */
public class UserInteractor implements UserBoundary {
    private UserGateway<UserData> gateway;

    public UserInteractor(UserGateway<UserData> gateway) {
        this.gateway = gateway;
    }

    public List<UserData> getUserList() {
        List<UserData> users = new ArrayList<>();
        return users;
    }

    public int createUser(CreateUserRequest request) {
        User user = new User(request.getName(), request.getPassword());
        List<String> errors = user.validate();
        int id = 0;
        if (errors.isEmpty()) {
            try {
                id = getNextId();
                gateway.createUser(id, new UserData(id, user.getName(), user.getPassword()));
            } catch (InvalidIdException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new EntityValidationException(errors = errors);
            } catch (EntityValidationException e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    private int getNextId() {
        return gateway.listUsers()
                .stream()
                .map(n -> n.getId())
                .reduce(0, (a, b) -> { if (a < b) return b; else return a; } ) + 1;
    }
}
