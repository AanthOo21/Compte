package org.example.models;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public abstract class Animal {
    private String name;
    private Date birthdate;

    public Animal(String name, Date birthdate){
        this.name = name;
        this.birthdate = birthdate;
    }

    public abstract void move();

}
