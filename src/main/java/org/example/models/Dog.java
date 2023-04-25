package org.example.models;

import java.util.Date;

public class Dog extends Animal {
    public Dog(String name, Date birthdate) {
        super(name, birthdate);
    }

    @Override
    public void move() {
        System.out.println("I'm a dog, and i run");
    }
    public void bark(){
        System.out.println("Wouf wouf");
    }
}
