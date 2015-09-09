package fi.github.marsojm.runnersnotes.boundary;

import java.util.Date;

/**
 * Created by Marko on 7.9.2015.
 */
public class NoteData {
    private int id;
    private Date created;
    private float distance;
    private int duration;
    private String comments;

    public NoteData(int id, Date created, float distance, int duration, String comments) {
        this.id = id;
        this.created = created;
        this.distance = distance;
        this.duration = duration;
        this.comments = comments;
    }

    public int getId() {
        return id;
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
