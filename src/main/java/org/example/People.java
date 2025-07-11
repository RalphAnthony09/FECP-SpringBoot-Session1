package org.example;

public class People {

    private String name;
    private String location;

    public People(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void goTo(String location) {
        this.location = location;
    }
}

class Visitor extends People{
    public Visitor(String name, String location) {
        super(name, location);
    }
}

class Manager extends People{
    public Manager(String name, String location) {
        super(name, location);
    }

    public void openZoo(){
        System.out.println("Zoo opened");
    }

    public void closeZoo(){
        System.out.printf("Zoo closed");
    }
}

class Vendor extends People{
    public Vendor(String name, String location) {
        super(name, location);
    }

    public void sell(){
        System.out.println("Sell stuff");
    }
}

class Handler extends People{
    public Handler(String name, String location) {
        super(name, location);
    }

    public void feed(){

    }

    public void exercise(){

    }

    public void examine(){

    }
}

class Veterinarian extends People{
    public Veterinarian(String name, String location) {
        super(name, location);
    }

    public void heal(){

    }

    public void lecture(){
        
    }
}
















