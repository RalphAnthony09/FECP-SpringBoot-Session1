package org.example;

import java.util.Scanner;

public class ZooTicketingModule {
    private Zoo zoo;
    private Scanner scanner;

    public ZooTicketingModule(Zoo zoo, Scanner scanner) {
        this.zoo = zoo;
        this.scanner = scanner;
    }

    public void ticketShop() {
        System.out.println("\n=== WELCOME TO THE ZOO TICKET SHOP ===");
        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures, Shops, and the Hospital.");
        System.out.print("\nWould you like to buy a ticket? (yes/no): ");
        String response = scanner.nextLine();

        if (response.trim().equalsIgnoreCase("yes")) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your age: ");
            int age = Integer.parseInt(scanner.nextLine());

            Visitor currentVisitor = new Visitor(name, zoo.getBuildingByName("Ticket Shop"));
            currentVisitor.setAge(age);

            String ticketType = ticketType(age);
            double price = ticketPricing(ticketType);

            System.out.printf("\nYou qualify for a %S ticket.\n", ticketType);
            System.out.printf("Ticket Price: P%.2f\n", price);
            System.out.print("Proceed with purchase? (yes/no) ");
            response = scanner.nextLine();

            if (response.trim().equalsIgnoreCase("yes")) {
                String generatedTicket = generateTicketNum();
                currentVisitor.setTicketCode(generatedTicket);

                zoo.addValidTicket(generatedTicket, currentVisitor);
                zoo.addPerson(currentVisitor);

                System.out.println("\nTicket purchased!");
                System.out.println("Your ticket code is: " + generatedTicket);
                System.out.println("[Ticket added to system]");
            } else {
                System.out.println("Purchase cancelled.");
            }
        } else {
            System.out.println("Purchase cancelled.");
        }
    }

    private String generateTicketNum() {
        int randomTicketNum = (int) (Math.random() * 9000) + 1000;
        return "ZOO-" + randomTicketNum;
    }

    private String ticketType(int age) {
        if (age <= 5) return "Child";
        if (age <= 17) return "Student";
        if (age <= 59) return "Adult";
        return "Senior";
    }

    private double ticketPricing(String ticketType) {
        switch (ticketType) {
            case "Child": return 0.00;
            case "Student": return 75.00;
            case "Adult": return 150.00;
            case "Senior": return 50.00;
            default: return -1;
        }
    }
}
