package fi.github.marsojm.runnersnotes.boundary;

import java.util.Date;

/**
 * Created by Marko on 7.9.2015.
 */
public class CreateNoteRequest {
    private int userId;
    private Date created;
    private float distance;
    private int duration;
    private String comments;

    public CreateNoteRequest() {

    }

    public CreateNoteRequest(int userId, Date created, float distance, int duration, String comments) {
        this.userId = userId;
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

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getUserId() {
        return userId;
    }
}
