/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License (MIT).
 */

package de.muspellheim.events;

import java.util.function.Consumer;

/**
 * Example usage.
 *
 * @author Falko Schumann
 */
public class Example {

    private final Event<String> onMessage = new Event<>();

    public void addHandler(Consumer<String> handler) {
        onMessage.addHandler(handler);
    }

    public void removeHandler(Consumer<String> handler) {
        onMessage.removeHandler(handler);
    }

    protected void sendMessage(String message) {
        onMessage.send(message);
    }

    // much more code

}
