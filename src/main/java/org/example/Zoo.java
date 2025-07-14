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
        buildings.add(new Enclosure("Pachyderm Enclosure"));
        buildings.add(new Enclosure("Feline Enclosure"));
        buildings.add(new Enclosure("Bird Enclosure"));
        buildings.add(new Hospital("Animal Hospital"));
        buildings.add(new TicketShop("Ticket Shop"));
        buildings.add(new FoodShop("Food Shop"));
    }

    public void addPerson(People person) {
        if (!people.contains(person)) {
            people.add(person);
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

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

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
}
