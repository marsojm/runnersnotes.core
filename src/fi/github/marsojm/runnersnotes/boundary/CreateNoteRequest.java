package fi.github.marsojm.runnersnotes.boundary;

import java.util.Date;

/**
 * Created by Marko on 7.9.2015.
 */
public class CreateNoteRequest {
    private Date created;
    private float distance;
    private int duration;
    private String comments;

    public CreateNoteRequest(Date created, float distance, int duration, String comments) {

        this.created = created;
        this.distance = distance;
        this.duration = duration;
        this.comments = comments;
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
