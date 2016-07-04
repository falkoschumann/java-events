/*
 * Copyright (c) 2016 Falko Schumann
 * Released under the terms of the MIT License (MIT).
 */

package de.muspellheim.events;

/**
 * Shorter example usage.
 *
 * @author Falko Schumann
 */
public class ShorterExample {

    public final Event<String> onMessage = new Event<>();

    // much more code

    public static void usage() {
        ShorterExample example = new ShorterExample();
        example.onMessage.addHandler(m -> System.out.println(m));
    }

}
