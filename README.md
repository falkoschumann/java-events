[![Build Status](https://travis-ci.org/falkoschumann/java-events.svg?branch=develop)](https://travis-ci.org/falkoschumann/java-events)
[![Download](https://api.bintray.com/packages/falkoschumann/maven/events/images/download.svg)](https://bintray.com/falkoschumann/maven/events)


Events
======

A Java 8 lambda based event mechanism with simple and short notation.


Introduction
------------

The common event mechanism in Java for messaging are event listeners and events.
This needs a listener interface, an event class and a lot of boiler plate code
for adding and remove listeners and firing events.

The same boiler plate code is needed for implements Bean Properties. Java FX
introduce new property classes to reduce this boiler plate code.

This library will reduce the boiler plate code for event messaging. It is easier
than the Java FX event mechanism. The Java FX events are designed for UI events.
The events in this library are much more easier to use, because there are
designed for common use with all plain old Java objects (POJOs).


Usage
-----

An event can be every object. The event type is defined by a generic type. An
action is an event without message.

    private Event<String> onMessage;
    private Action onAction;

An event can also be an primitive type `int`, `long` or `double`.

    private IntEvent    onIntMessage;
    private LongEvent   onLongMessage;
    private DoubleEvent onDoubleMessage;

An full example POJO can be like ...

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

Or shorter ...

    public class ShorterExample {

        public final Event<String> onMessage = new Event<>();
        public final Action onAction = new Action();

        // much more code

    }

The shorter way direct call the methods on `Event` and do not delegate.

    ShorterExample example = new ShorterExample();
    example.onMessage.addHandler(m -> System.out.println("message send: " + m));

    ShorterExample example = new ShorterExample();
    example.onAction.addHandler(() -> System.out.println("action triggered"));
