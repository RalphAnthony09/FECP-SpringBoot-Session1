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

class Visitor extends People {
    private int age;
    private String ticketCode;

    public Visitor(String name, String location) {
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

    public String getTicketCode() {
        return ticketCode;
    }
}


class Manager extends People{
    private String password;

    public Manager(String name, String location, String password) {
        super(name, location);
        this.password = password;
    }

    public String getPassword() {
        return password;
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
















