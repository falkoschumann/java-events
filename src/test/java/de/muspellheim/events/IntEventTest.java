/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

import org.junit.jupiter.api.*;

import java.util.function.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for integer events.
 *
 * @author Falko Schumann
 */
public class IntEventTest {

    private int message;
    private Throwable exception;

    /**
     * Test with three steps.
     * <ol>
     * <li>Add an handler, a message is received.</li>
     * <li>Add an other handler throwing an exception, the exception will be handled.</li>
     * <li>Remove first handler, no message is received</li>
     * </ol>
     */
    @Test
    public void testSendingEvents() {
        IntEvent event = new IntEvent();
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> exception = e);

        IntConsumer handler = this::saveMessage;
        event.addHandler(handler);
        event.send(3);
        assertEquals(3, message);
        assertNull(exception);

        event.addHandler(this::throwException);
        event.send(5);
        assertEquals(5, message);
        assertEquals("Fubar", exception.getMessage());

        event.removeHandler(handler);
        event.send(8);
        assertEquals(5, message);
    }

    private void saveMessage(int message) {
        this.message = message;
    }


    private void throwException(int message) {
        throw new RuntimeException("Fubar");
    }

}
