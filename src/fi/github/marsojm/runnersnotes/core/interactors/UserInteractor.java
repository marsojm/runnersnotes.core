package fi.github.marsojm.runnersnotes.core.interactors;

import fi.github.marsojm.runnersnotes.boundary.UserData;
import fi.github.marsojm.runnersnotes.gateway.boundaries.UserGateway;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marko on 20.9.2015.
 */
public class UserInteractor {
    private UserGateway<UserData> gateway;

    public UserInteractor(UserGateway<UserData> gateway) {
        this.gateway = gateway;
    }

    public List<UserData> getUserList() {
        List<UserData> users = new ArrayList<>();
        return users;
    }
}
