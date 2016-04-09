/*
 * Copyright (c) 2016 Falko Schumann <www.muspellheim.de>
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

import java.util.function.Consumer;

public class Example {

    private Event<String> onMessage = new Event<>();

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
