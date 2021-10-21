package org.example.observers;

@FunctionalInterface
public interface Subscriber {

    void execute(int number);
}
