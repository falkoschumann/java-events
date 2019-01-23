/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

/**
 * An event send a message to handlers.
 *
 * @param <T> the message type.
 * @author Falko Schumann
 */
public class Event<T> {

    private final List<Consumer<T>> handlers = new CopyOnWriteArrayList<>();

    /**
     * Adds a handler to notify it of sending events.
     *
     * @param handler the handler to add.
     */
    public void addHandler(Consumer<T> handler) {
        Objects.requireNonNull(handler, "handler");
        handlers.add(handler);
    }

    /**
     * Removes a handler to not notify it anymore.
     *
     * @param handler the handler to remove.
     */
    public void removeHandler(Consumer<T> handler) {
        Objects.requireNonNull(handler, "handler");
        handlers.remove(handler);
    }

    /**
     * Sends a message to all added handlers.
     *
     * @param message the message to send.
     */
    public void send(T message) {
        handlers.forEach(handler -> {
            try {
                handler.accept(message);
            } catch (Exception e) {
                Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
            }
        });
    }

}
