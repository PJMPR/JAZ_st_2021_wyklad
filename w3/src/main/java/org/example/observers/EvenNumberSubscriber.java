package org.example.observers;

public class EvenNumberSubscriber implements Subscriber{
    @Override
    public void execute(int number) {
        if(number%2==0)
            System.out.println(number +" jest parzysta");
    }
}
