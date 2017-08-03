/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

/**
 * Example action usage.
 *
 * @author Falko Schumann
 */
public class ActionExample {

    private final Action onMessage = new Action();

    public void addHandler(Runnable handler) {
        onMessage.addHandler(handler);
    }

    public void removeHandler(Runnable handler) {
        onMessage.removeHandler(handler);
    }

    protected void trigger() {
        onMessage.trigger();
    }

    // much more code

}
