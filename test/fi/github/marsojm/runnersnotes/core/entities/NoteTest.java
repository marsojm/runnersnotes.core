package fi.github.marsojm.runnersnotes.core.entities;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marko on 3.9.2015.
 */
public class NoteTest {


    @Test
    public  void testCreateNote() throws Exception {
        Note n = new Note(new Date(), 20, 20, "");
    }

    @Test
    public void testValidate() throws Exception {
        Note n = new Note(new Date(), 20, 20, "");
        List<String> errors = n.validate();
        assertEquals(0, errors.size());
    }

    @Test
    public void testValidateWithTwoErrors() throws Exception {
        Note n = new Note(new Date(), -1, -1, "");
        List<String> errors = n.validate();
        assertEquals(2, errors.size());
    }


    @Test
    public void testValidateNegativeDistance() throws Exception {
        Note n = new Note(new Date(), -1, 20, "");
        List<String> errors = n.validate();
        assertEquals(1, errors.size());
        assertEquals("Distance must be greater than zero!", errors.get(0));
    }

    @Test
    public void testValidateNegativeDuration() throws Exception {
        Note n = new Note(new Date(), 1, -1, "");
        List<String> errors = n.validate();
        assertEquals(1, errors.size());
        assertEquals("Duration must be greater than zero!", errors.get(0));
    }

}