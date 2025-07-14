package org.example;

import java.util.ArrayList;

public abstract class People {
    private String name;
    private Building location;

    public People(String name, Building location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Building getLocation() {
        return location;
    }

    public void goTo(Building location) {
        this.location = location;
        System.out.println(this.name + " is now at " + location.getName());
    }
}

class Visitor extends People {
    private int age;
    private String ticketCode;

    public Visitor(String name, Building location) {
        super(name, location);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }
}

class Manager extends People {
    private String password;

    public Manager(String name, Building location, String password) {
        super(name, location);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void openZoo(Zoo zoo) {
        zoo.setOpen(true);
    }

    public void closeZoo(Zoo zoo) {
        zoo.setOpen(false);
    }
}

class Vendor extends People {
    public Vendor(String name, Building location) {
        super(name, location);
    }
}

class Handler extends People {
    ArrayList<Animal> animalsHandled = new ArrayList<>();

    public Handler(String name, Building location) {
        super(name, location);
    }

    public void assignAnimal(Animal animalAssignment){
        animalsHandled.add(animalAssignment);
    }

    public void getAnimalsHandled(){
        for (Animal animal : animalsHandled) {
            System.out.println(animal.getName());
        }
    }
}

class Veterinarian extends People {
    public Veterinarian(String name, Building location) {
        super(name, location);
    }
}
