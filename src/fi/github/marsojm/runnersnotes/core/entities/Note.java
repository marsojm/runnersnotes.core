package fi.github.marsojm.runnersnotes.core.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Marko on 3.9.2015.
 */
public class Note {
    private Date created;
    private float distance;
    private int duration;
    private String comments;

    public Note(Date created, float distance, int duration, String comments) {
        this.created = created;
        this.distance = distance;
        this.duration = duration;
        this.comments = comments;
    }

    public List<String> validate() {
        List<String> errors = new ArrayList<String>();
        if (this.distance < 0) errors.add("Distance must be greater than zero!");
        if (this.duration < 0) errors.add("Duration must be greater than zero!");
        return errors;
    }

    public Date getCreated() {
        return created;
    }

    public float getDistance() {
        return distance;
    }

    public int getDuration() {
        return duration;
    }

    public String getComments() {
        return comments;
    }
}
