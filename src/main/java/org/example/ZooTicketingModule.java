package org.example;

import java.util.*;

public class ZooTicketingModule {

    private int randomTicketNum;
    private Set<String> ticketDatabase = new HashSet<>();

    private String visitorName;
    private int visitorAge;
    private String visitorTicket;

    // Generate ticket for the visitor
    public String generateTicketNum() {
        randomTicketNum = (int) (Math.random() * 10000);
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
        else if (age <= 18 && age <= 59) {
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
                break;
            case "Student":
                return 75.00;
                break;
            case "Adult":
                return 150.00;
                break;
            case "Senior":
                return 50.00;
                break;
            default:
                return -1;
        }
    }

    public void ticketShop() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WELCOME TO THE ZOO TICKET SHOP ===");
        System.out.println("");
        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures (Elephant, Lion, Owl");
        System.out.println("Buy snacks and drinks from our Shops");
        System.out.println("Listen to science lectures at the Hospital");
        System.out.println("Buy fun gifts at our Gift Shop");
        System.out.println("");
        System.out.printf("Would you like to buy a ticket? (yes/no): ");

        String response = scanner.nextLine();

        if (response.trim().equalsIgnoreCase("yes")) {

            System.out.printf("Enter your name: ");
            visitorName = scanner.nextLine();

            System.out.printf("Enter your age: ");
            visitorAge = scanner.nextInt();
            scanner.nextLine();

            String ticketType = ticketType(visitorAge);
            double price = ticketPricing(ticketType);

            if (ticketType.equals("Unknown")) {
                System.out.println("Sorry, your age group is not supported yet.");
                return;
            }

            System.out.println("");
            System.out.println("You qualify for a " + ticketType.toUpperCase() + " ticket.");
            System.out.println("Ticket Price: ₱" + price);
            System.out.println("");
            System.out.printf("Proceed with purchase? (yes/no) ");

            response = scanner.nextLine();

            if (response.trim().equalsIgnoreCase("yes")) {
                System.out.println("");
                System.out.println("Ticket purchased!");
                visitorTicket = generateTicketNum();
                System.out.println("Your ticket code is: " + visitorTicket);
                System.out.println("");
                System.out.println("[Ticket added to system]");
            }

        }
    }
    
}
