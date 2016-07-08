/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License (MIT).
 */

package de.muspellheim.events;

/**
 * Shorter example event usage.
 *
 * @author Falko Schumann
 */
public class ShorterEventExample {

    public final Event<String> onMessage = new Event<>();

    // much more code

    public static void usage() {
        ShorterEventExample example = new ShorterEventExample();
        example.onMessage.addHandler(m -> System.out.println(m));
    }

}
