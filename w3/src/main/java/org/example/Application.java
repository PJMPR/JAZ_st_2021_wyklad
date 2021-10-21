package org.example;

import org.example.observers.Emitter;
import org.example.observers.EvenNumberSubscriber;
import org.example.observers.Subscriber;

public class Application {

    public static void main(String[] args){
        Emitter emitter = new Emitter();

        Subscriber notEvenNumberSubscriber = new Subscriber() {
            @Override
            public void execute(int number) {
                if(number%2==1)
                    System.out.println(number + " jest nieparzysta");
            }
        };

        emitter.register(new EvenNumberSubscriber());
        emitter.register(notEvenNumberSubscriber);
        emitter.register(number->System.out.println("pokaz: " + number));


        Subscriber lambda = number->System.out.println("wyswietl: " + number);


        emitter.emit(1);
        emitter.emit(2);
        emitter.emit(3);
        emitter.emit(4);

        lambda.execute(10);

    }


}
