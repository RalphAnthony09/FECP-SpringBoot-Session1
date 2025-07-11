package org.example;

import java.util.*;

public class ZooTicketingModule {

    private final Map<String, String> ticketDatabase = new HashMap<>();

    private final Visitor visitor;
    private String visitorTicket;

    public ZooTicketingModule(Visitor visitor, String visitorTicket) {
        this.visitor = visitor;
        this.visitorTicket = visitorTicket;
    }

    // Generate ticket for the visitor
    public String generateTicketNum() {
        int randomTicketNum = (int) (Math.random() * 10000);
        return "ZOO-" + randomTicketNum;
    }

    // Determine Ticket type for pricing of tickets.
    public String ticketType(int age) {
        if (age <= 5) {
            return "Child";
        }
        else if (6 <= age && age <= 17) {
            return "Student";
        }
        else if (18 <= age && age <= 59) {
            return "Adult";
        }
        else {
            return "Senior";
        }
    }

    public double ticketPricing(String ticketType) {
        switch (ticketType) {
            case "Child":
                return 0.00;
            case "Student":
                return 75.00;
            case "Adult":
                return 150.00;
            case "Senior":
                return 50.00;
            default:
                return -1;
        }
    }

    // For buying Zoo Tickets
    public void ticketShop() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WELCOME TO THE ZOO TICKET SHOP ===");
        System.out.println();
        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures (Elephant, Lion, Owl");
        System.out.println("Buy snacks and drinks from our Shops");
        System.out.println("Listen to science lectures at the Hospital");
        System.out.println("Buy fun gifts at our Gift Shop");
        System.out.println();
        System.out.print("Would you like to buy a ticket? (yes/no): ");

        String response = scanner.nextLine();

        if (response.trim().equalsIgnoreCase("yes")) {

            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            Visitor currentVisitor = new Visitor(name, "Ticket Shop");

            String ticketType = ticketType(age);
            double price = ticketPricing(ticketType);

            if (ticketType.equals("Unknown")) {
                System.out.println("Sorry, your age group is not supported yet.");
                return;
            }

            System.out.println();
            System.out.println("You qualify for a " + ticketType.toUpperCase() + " ticket.");
            System.out.println("Ticket Price: ₱" + price);
            System.out.println();
            System.out.print("Proceed with purchase? (yes/no) ");

            response = scanner.nextLine();

            if (response.trim().equalsIgnoreCase("yes")) {
                System.out.println();
                System.out.println("Ticket purchased!");

                String generatedTicket = generateTicketNum();

                ticketDatabase.put(generatedTicket, currentVisitor.getName());
                this.visitorTicket = generatedTicket;

                System.out.println("Your ticket code is: " + generatedTicket);
                System.out.println();

                System.out.println("[Ticket added to system]");
            }
            else if (response.trim().equalsIgnoreCase("no")) {
                System.out.println("Purchase cancelled.");
            }
        }

        else if (response.trim().equalsIgnoreCase("no")) {
            System.out.println("Purchase cancelled.");
        }
    }

    // For checking validity of tickets
    public boolean ticketChecker(String ticketCode) {
        if(ticketDatabase.containsKey(ticketCode)) {
            String visitorName = ticketDatabase.get(ticketCode);
            System.out.println("Ticket found for " + ticketCode);
            return true;
        }
        else {
            System.out.println("Ticket not found.");
            return false;
        }
    }

    // Get the visitor name through ticket code
    public String getVisitorNameByTicketCode(String ticketCode) {
        return ticketDatabase.get(ticketCode);
    }
}
