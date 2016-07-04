/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License (MIT).
 */

package de.muspellheim.events;

import org.junit.Test;

import java.util.function.LongConsumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for long events.
 *
 * @author Falko Schumann
 */
public class LongEventTest {

    private long message;
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
        LongEvent event = new LongEvent();
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> exception = e);

        LongConsumer handler = this::saveMessage;
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

    private void saveMessage(long message) {
        this.message = message;
    }


    private void throwException(long message) {
        throw new RuntimeException("Fubar");
    }

}
