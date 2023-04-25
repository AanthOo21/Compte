package org.example.models;

import java.util.Date;

public class Bird extends Animal{
    public Bird(String name, Date birthdate) {
        super(name, birthdate);
    }

    @Override
    public void move() {
        System.out.println("I'm a bird, and i fly");
    }
    public void shit(){
        System.out.println("Take that !");
    }
}
