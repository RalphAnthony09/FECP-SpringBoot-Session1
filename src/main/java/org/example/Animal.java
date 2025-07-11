package org.example;

interface Specie{
    String getSpecie();
    String getLocation();
    void setLocation(String newLocation);
}

public abstract class Animal implements Specie {

    private String animalName;
    private boolean isHealthy;
    private String location;

    public Animal(String animalName, boolean isHealthy, String location) {
        this.animalName = animalName;
        this.isHealthy = isHealthy;
        this.location = location;
    }

    public void eat(){

    }

    public void sleep(){

    }

    public void roam(){

    }

    public void makeSound(){
        System.out.println("sound");
    }

    @Override
    public String getLocation(){
        return location;
    }

    @Override
    public void setLocation(String newLocation){
        this.location = newLocation;
    }
}

class Pachyderm extends Animal{
    public Pachyderm(String animalName, boolean isHealthy, String location) {
        super(animalName, isHealthy, location);
    }

    @Override
    public void makeSound(){
        System.out.println("Pachyderm sound");
    }

    @Override
    public String getSpecie(){
        return "Pachyderm";
    }
}

class Feline extends Animal{
    public Feline(String animalName, boolean isHealthy, String location) {
        super(animalName, isHealthy, location);
    }

    @Override
    public void makeSound(){
        System.out.println("Feline sound");
    }

    @Override
    public String getSpecie(){
        return "Feline";
    }
}

class Bird extends Animal{
    public Bird(String animalName, boolean isHealthy, String location) {
        super(animalName, isHealthy, location);
    }

    @Override
    public void makeSound(){
        System.out.println("Bird sound");
    }

    @Override
    public String getSpecie(){
        return "Bird";
    }
}