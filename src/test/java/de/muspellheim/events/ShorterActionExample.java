/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License (MIT).
 */

package de.muspellheim.events;

/**
 * Shorter example action usage.
 *
 * @author Falko Schumann
 */
public class ShorterActionExample {

    public final Action onAction = new Action();

    // much more code

    public static void usage() {
        ShorterActionExample example = new ShorterActionExample();
        example.onAction.addHandler(() -> System.out.println("action triggered"));
    }

}
