package kr.mjc.lhs.basics.generics;

public class GenericBox<T> {

    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }
}

