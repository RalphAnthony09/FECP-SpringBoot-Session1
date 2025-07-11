package org.example;

import java.util.HashSet;
import java.util.Set;

// PLACEHOLDER JAVA CLASS TO MAKE THE PROGRAM WORK IN THE MOST MINIMAL WAY POSSIBLE.

public class Zoo {
    private Set<String> validTickets = new HashSet<>();
    private Set<Visitor> visitors = new HashSet<>();

    public void addValidTicket(String ticketCode) {
        validTickets.add(ticketCode);
    }

    public boolean isTicketValid(String ticketCode) {
        return validTickets.contains(ticketCode);
    }

    public void addPerson(Visitor visitor) {
        visitors.add(visitor);
    }

    public String getTicketShop() {
        return "Ticket Shop";
    }
}
