package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();
    private List<People> people = new ArrayList<>();
    private List<Building> buildings = new ArrayList<>();
    private Map<String, Visitor> validTickets = new HashMap<>();
    private boolean isOpen = false;

    public Zoo() {
        Building pEnclosure = new Enclosure("Pachyderm Enclosure");
        Building fEnclosure = new Enclosure("Feline Enclosure");
        Building bEnclosure = new Enclosure("Bird Enclosure");
        buildings.add(pEnclosure);
        buildings.add(fEnclosure);
        buildings.add(bEnclosure);
        buildings.add(new Hospital("Animal Hospital"));
        buildings.add(new TicketShop("Ticket Shop"));
        buildings.add(new FoodShop("Food Shop"));

        animals.add(new Pachyderm("Dumbo", true, pEnclosure));
        animals.add(new Feline("Simba", true, fEnclosure));
        animals.add(new Bird("Zazu", true, bEnclosure));
    }

    public void addPerson(People person) {
        if (!people.contains(person)) {
            people.add(person);
        }
    }

    public void addAnimal(Animal animal) {
        if (!animals.contains(animal)) {
            animals.add(animal);
        }
    }

    public void addValidTicket(String ticketCode, Visitor visitor) {
        validTickets.put(ticketCode, visitor);
    }

    public boolean isTicketValid(String ticketCode) {
        return validTickets.containsKey(ticketCode);
    }

    public Visitor getVisitorByTicket(String ticketCode) {
        return validTickets.get(ticketCode);
    }

    public List<People> getPeople() { return people; }
    public List<Animal> getAnimals() { return animals; }
    public boolean isOpen() { return isOpen; }
    public void setOpen(boolean open) { isOpen = open; }

    public List<Enclosure> getEnclosures() {
        return buildings.stream()
                .filter(b -> b instanceof Enclosure)
                .map(b -> (Enclosure) b)
                .collect(Collectors.toList());
    }

    public Building getBuildingByName(String name) {
        return buildings.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Shop getFoodShop() {
        return (Shop) buildings.stream()
                .filter(b -> b instanceof FoodShop)
                .findFirst()
                .orElse(null);
    }
}
