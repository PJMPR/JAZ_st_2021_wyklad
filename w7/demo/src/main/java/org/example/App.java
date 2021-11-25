package org.example;

import org.example.queries.QueryProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner
{

    QueryProcessor processor;

    public App(QueryProcessor processor) {
        this.processor = processor;
    }

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello?");
    }
}
