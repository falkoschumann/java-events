[![Build Status](https://travis-ci.org/falkoschumann/java-events.svg?branch=master)](https://travis-ci.org/falkoschumann/java-events)
[![GitHub release](https://img.shields.io/github/release/falkoschumann/java-events.svg)]()


Events
======

A Java 8 lambda based event mechanism with simple and short notation.

The common event mechanism in Java for messaging are event listeners and events.
This needs a listener interface, an event class and a lot of boiler plate code
for adding and remove listeners and firing events.

The same boiler plate code is needed for implements Bean Properties. Java FX
introduce new property classes to reduce this boiler plate code.

This library will reduce the boiler plate code for event messaging. It is easier
than the Java FX event mechanism. The Java FX events are designed for UI events.
The events in this library are much more easier to use, because there are
designed for common use with all plain old Java objects (POJOs).


Installation
------------

### Gradle

Add the the repository _jcenter_ to your `build.gradle`

    repositories {
        jcenter()
    }

and add the dependency

    compile 'de.muspellheim:events:1.0.1'


### Maven

Add the the repository _jcenter_ to your `pom.xml`
    
    <repositories>
        <repository>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <id>central</id>
            <name>bintray</name>
            <url>http://jcenter.bintray.com</url>
        </repository>
    </repositories>

and add the dependency

    <dependencies>
        <dependency>
            <groupId>de.muspellheim</groupId>
            <artifactId>events</artifactId>
            <version>1.0.1</version>
        </dependency>
    </dependencies>


### Download

You can download JARs with binary, source and JavaDoc from GitHub under
https://github.com/falkoschumann/java-events/releases.


Usage
-----

An event can be every object. The event type is defined by a generic type. An
action is an event without message.

    Event<String> onMessage;
    Action onAction;

An event can also be an primitive type `int`, `long` or `double`.

    IntEvent    onIntMessage;
    LongEvent   onLongMessage;
    DoubleEvent onDoubleMessage;

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

... and direct call the methods on `Event` and `Action` without delegating.

    ShorterExample example = new ShorterExample();
    example.onMessage.addHandler(m -> System.out.println("message send: " + m));

    ShorterExample example = new ShorterExample();
    example.onAction.addHandler(() -> System.out.println("action triggered"));


Contributing
------------

### Publish artifacts to Bintray

1.  Create file `gradle.properties` and set properties `bintrayUser` and
    `bintrayApiKey`.
2.  Run `./gradlew uploadArchives`.
3.  Check uploaded files and publish.

### Publish distribution to GitHub

1.  Run `./gradle distZip`.
2.  Upload created ZIP to GitHub releases.
