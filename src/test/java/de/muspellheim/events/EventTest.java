/*
 * Copyright (c) 2016 Falko Schumann <www.muspellheim.de>
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

import org.junit.Test;

import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Unit test for generic events.
 *
 * @author Falko Schumann &lt;falko.schumann@muspellheim.de&gt;
 */
public class EventTest {

    private String message;
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
        Event<String> event = new Event<>();
        Thread.currentThread().setUncaughtExceptionHandler((t, e) -> exception = e);

        Consumer<String> handler = this::saveMessage;
        event.addHandler(handler);
        event.send("Foo");
        assertEquals("Foo", message);
        assertNull(exception);

        event.addHandler(this::throwException);
        event.send("Foobar");
        assertEquals("Foobar", message);
        assertEquals("Fubar", exception.getMessage());

        event.removeHandler(handler);
        event.send("Bar");
        assertEquals("Foobar", message);
    }

    private void saveMessage(String message) {
        this.message = message;
    }


    private void throwException(String message) {
        throw new RuntimeException("Fubar");
    }

}
