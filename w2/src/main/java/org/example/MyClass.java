package org.example;

import org.example.annotations.CustomClassName;
import org.example.annotations.DefaultValue;
import org.example.annotations.Init;

@CustomClassName(name = "Moja Klasa")
public class MyClass {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Init
    public void execute(
            @DefaultValue(myValue = "text")
            String s){
        System.out.println("Dzialam " + s );
    }
}
