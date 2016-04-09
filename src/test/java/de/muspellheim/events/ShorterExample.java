/*
 * Copyright (c) 2016 Falko Schumann <www.muspellheim.de>
 * Released under the terms of the MIT License.
 */

package de.muspellheim.events;

public class ShorterExample {

    public Event<String> onMessage = new Event<>();

    // much more code

    public static void usage() {
        ShorterExample example = new ShorterExample();
        example.onMessage.addHandler(m -> System.out.println(m));
    }

}
