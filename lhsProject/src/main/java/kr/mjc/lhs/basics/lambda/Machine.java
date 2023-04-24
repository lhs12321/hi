package kr.mjc.lhs.basics.lambda;

import java.util.function.Consumer;

public class Machine {

    public void doTwice(Runnable runnable) {
        runnable.run();
        runnable.run();
    }

    public void doTwice(Consumer<String> consumer, String name) {
        consumer.accept(name);
        consumer.accept(name);
    }


}
