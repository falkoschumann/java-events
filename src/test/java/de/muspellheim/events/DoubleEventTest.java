/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License (MIT).
 */

package de.muspellheim.events;

import org.junit.Test;

import java.util.function.DoubleConsumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for double events.
 *
 * @author Falko Schumann
 */
public class DoubleEventTest {

    private double message;
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
        DoubleEvent event = new DoubleEvent();
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> exception = e);

        DoubleConsumer handler = this::saveMessage;
        event.addHandler(handler);
        event.send(3.4);
        assertEquals(3.4, message, 0.1);
        assertNull(exception);

        event.addHandler(this::throwException);
        event.send(5.6);
        assertEquals(5.6, message, 0.1);
        assertEquals("Fubar", exception.getMessage());

        event.removeHandler(handler);
        event.send(8.9);
        assertEquals(5.6, message, 0.1);
    }

    private void saveMessage(double message) {
        this.message = message;
    }


    private void throwException(double message) {
        throw new RuntimeException("Fubar");
    }

}
