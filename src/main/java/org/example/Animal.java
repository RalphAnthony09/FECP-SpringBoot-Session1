package org.example;

interface Specie {
    String getSpecie();
    Building getLocation();
    void setLocation(Building newLocation);
}

public abstract class Animal implements Specie {
    private String animalName;
    private boolean isHealthy;
    private Building location;

    public Animal(String animalName, boolean isHealthy, Building location) {
        this.animalName = animalName;
        this.isHealthy = isHealthy;
        this.location = location;
    }

    public String getName() { return animalName; }
    public void eat() { System.out.println(animalName + " is eating."); }
    public void makeSound() { System.out.println(animalName + " makes a sound."); }

    @Override
    public Building getLocation() { return location; }

    @Override
    public void setLocation(Building newLocation) { this.location = newLocation; }
}

class Pachyderm extends Animal {
    public Pachyderm(String animalName, boolean isHealthy, Building location) {
        super(animalName, isHealthy, location);
    }
    @Override public String getSpecie() { return "Pachyderm"; }
}

class Feline extends Animal {
    public Feline(String animalName, boolean isHealthy, Building location) {
        super(animalName, isHealthy, location);
    }
    @Override public String getSpecie() { return "Feline"; }
}

class Bird extends Animal {
    public Bird(String animalName, boolean isHealthy, Building location) {
        super(animalName, isHealthy, location);
    }
    @Override public String getSpecie() { return "Bird"; }
}
