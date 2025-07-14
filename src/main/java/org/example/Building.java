package org.example;

import java.util.ArrayList;

public abstract class Building {
    String name;

    public Building(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class Hospital extends Building {
    public Hospital(String name) {
        super(name);
    }
}

class Enclosure extends Building {
    ArrayList<Animal> animalsInside = new ArrayList<>();

    public Enclosure(String name) {
        super(name);
    }

    public void addAnimal(Animal animalToBeAdded){
        animalsInside.add(animalToBeAdded);
    }

    public void getAnimalsInside(){
        for (Animal animal : animalsInside) {
            System.out.println(animal.getName());
        }
    }
}

abstract class Shop extends Building {
    public Shop(String name) {
        super(name);
    }
}

class TicketShop extends Shop {
    public TicketShop(String name) {
        super(name);
    }
}

class FoodShop extends Shop {
    public FoodShop(String name) {
        super(name);
    }
}

class DrinkShop extends Shop {
    public DrinkShop(String name) {
        super(name);
    }
}

class GiftShop extends Shop {
    public GiftShop(String name) {
        super(name);
    }
}
