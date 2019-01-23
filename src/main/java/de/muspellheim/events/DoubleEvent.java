/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

/**
 * An event send a double message to handlers.
 *
 * @author Falko Schumann
 */
public class DoubleEvent {

    private final List<DoubleConsumer> handlers = new CopyOnWriteArrayList<>();

    /**
     * Adds a handler to notify it of sending events.
     *
     * @param handler the handler to add.
     */
    public void addHandler(DoubleConsumer handler) {
        Objects.requireNonNull(handler, "handler");
        handlers.add(handler);
    }

    /**
     * Removes a handler to not notify it anymore.
     *
     * @param handler the handler to remove.
     */
    public void removeHandler(DoubleConsumer handler) {
        Objects.requireNonNull(handler, "handler");
        handlers.remove(handler);
    }

    /**
     * Sends a message to all added handlers.
     *
     * @param message the message to send.
     */
    public void send(double message) {
        handlers.forEach(handler -> {
            try {
                handler.accept(message);
            } catch (Exception e) {
                Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
            }
        });
    }

}
