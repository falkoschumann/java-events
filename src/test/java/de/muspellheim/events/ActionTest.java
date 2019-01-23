/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for action.
 *
 * @author Falko Schumann
 */
public class ActionTest {

    private boolean triggered;
    private Throwable exception;

    /**
     * Test with three steps.
     * <ol>
     * <li>Add an handler, an action is received.</li>
     * <li>Add an other handler throwing an exception, the exception will be handled.</li>
     * <li>Remove first handler, no action is received</li>
     * </ol>
     */
    @Test
    public void testSendingEvents() {
        var action = new Action();
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> exception = e);

        Runnable handler = this::trigger;
        action.addHandler(handler);
        action.trigger();
        assertTrue(triggered);
        assertNull(exception);

        action.addHandler(this::throwException);
        action.trigger();
        assertTrue(triggered);
        assertEquals("Foobar", exception.getMessage());

        action.removeHandler(handler);
        action.trigger();
        assertTrue(triggered);
    }

    private void trigger() {
        triggered = true;
    }


    private void throwException() {
        throw new RuntimeException("Foobar");
    }

}
