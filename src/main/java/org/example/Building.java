package org.example;

import java.util.ArrayList;

public abstract class Building {
    String name;

    public Building(String name) {
        this.name = name;
    }

    public abstract String getType();
}

class Hospital extends Building{
    ArrayList<Animal> sickAnimals = new ArrayList<>();

    public Hospital(String name) {
        super(name);
    }

    @Override
    public String getType(){
        return "Hospital";
    }
}

class Enclosure extends Building{
    ArrayList<Animal> enclosedAnimals = new ArrayList<>();

    public Enclosure(String name) {
        super(name);
    }

    @Override
    public String getType(){
        return "Building";
    }
}

abstract class Shop extends Building{
    public Shop(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return getShopType() + " Shop";
    }

    public abstract String getShopType();
}

class TicketShop extends Shop{
    public TicketShop(String name) {
        super(name);
    }

    @Override
    public String getShopType(){
        return "Ticket";
    }
}

class FoodShop extends Shop{
    public FoodShop(String name) {
        super(name);
    }

    @Override
    public String getShopType(){
        return "Food";
    }
}

class DrinkShop extends Shop{
    public DrinkShop(String name) {
        super(name);
    }

    @Override
    public String getShopType(){
        return "Drink";
    }
}

class GiftShop extends Shop{
    public GiftShop(String name) {
        super(name);
    }

    @Override
    public String getShopType(){
        return "Gift";
    }
}