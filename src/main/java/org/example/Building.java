package org.example;

import java.util.ArrayList;
import java.util.List;

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
    public Enclosure(String name) {
        super(name);
    }
}

abstract class Shop extends Building {
    protected List<Product> products = new ArrayList<>();
    public Shop(String name) { super(name); }
    public List<Product> getProducts() { return products; }
}

class TicketShop extends Shop {
    public TicketShop(String name) {
        super(name);
    }
}

class FoodShop extends Shop {
    public FoodShop(String name) {
        super(name);
        // Add default products to the food shop
        products.add(new Product("Soft Drink", 30));
        products.add(new Product("Popcorn", 50));
        products.add(new Product("Plush Toy", 120));
        products.add(new Product("Keychain", 45));
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

class Product {
    private String name;
    private double price;
    public Product(String name, double price) { this.name = name; this.price = price; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
