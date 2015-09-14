package fi.github.marsojm.runnersnotes.core.interactors;

import java.util.List;

/**
 * Created by Marko on 14.9.2015.
 */
public class EntityValidationException extends Throwable {
    private List<String> errors;

    public EntityValidationException(List<String> errors) {

        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
