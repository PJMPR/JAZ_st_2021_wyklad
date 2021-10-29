package org.example;

import org.example.model.Gender;
import org.example.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class App {


    static List<Person> sampleResult = new ArrayList<>();
    public static void main(String[] args){

        List<Person> people = Arrays.asList(
                new Person("jan", "kowalski", 20, 1000, Gender.MALE),
                new Person("Maciej", "Nowak", 40, 14000, Gender.MALE),
                new Person("Maciej", "Nowak", 40, 14000, Gender.MALE),
                new Person("Anna", "Nowicka", 35, 5000, Gender.FEMALE),
                new Person("Anna", "Nowicka", 35, 5000, Gender.FEMALE),
                new Person("Anna", "Nowicka", 35, 5000, Gender.FEMALE),
                new Person("jan", "kowalski", 20, 1000, Gender.MALE),
                new Person("Bozena", "Jasminowa", 24, 2500, Gender.FEMALE)
        );

        people.stream()
                .filter(person->person.getGender()==Gender.MALE)
                .filter(person -> person.getAge()>30)
                .filter(person -> person.getIncome()>3000)
                .forEach(person->{
                    sampleResult.add(person);
                    System.out.println(person.getName()+" "+person.getSurname());});

        sampleResult = people.stream()
                .filter(person->person.getGender()==Gender.MALE)
                .filter(person -> person.getAge()>30)
                .filter(person -> person.getIncome()>3000)
                .skip(6)
                .limit(6)
                        .toList();

        people.stream().filter(person->person.getGender()==Gender.FEMALE).findFirst().orElseGet(null);



        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        people.stream()
                .map(person -> person.getName() + " " + person.getSurname())
                .distinct()
                .forEach(fullname->System.out.println(fullname));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        double avarage = people.stream()
                .filter(person -> person.getIncome()>3000)
                        .collect(Collectors.averagingInt(person->person.getAge()));

        System.out.println("Srednia wieku: "+ avarage);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");



        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        for (Person person : people) {
             if(person.getGender()==Gender.FEMALE){
                 if(person.getAge()>30){
                     if(person.getIncome()>3000)
                         System.out.println(person.getName()+" "+person.getSurname());
                 }

         }

        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

        IntStream.range(1,20).forEach(i->System.out.println(i));
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        IntStream.range(1,20).parallel().forEach(i->System.out.println(i));
    }
static int i =0;



}
