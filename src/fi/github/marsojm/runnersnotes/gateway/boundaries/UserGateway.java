package fi.github.marsojm.runnersnotes.gateway.boundaries;

import java.util.List;

/**
 * Created by Marko on 18.9.2015.
 */
public interface UserGateway<T> {
    T getUser(int userId);
    List<T> listUsers();
    void createUser(int userId,  T user) throws InvalidIdException;
}
