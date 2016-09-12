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
