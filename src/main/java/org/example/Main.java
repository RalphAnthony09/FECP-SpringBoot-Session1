package org.example;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        zoo.initializeDefaultState();

        while (true) {
            System.out.println("\n\n=== WELCOME TO THE ZOO SIMULATION ===");
            System.out.println("1. Administrator Console");
            System.out.println("2. Visitor Ticketing & Entry");
            System.out.println("3. Exit Simulation");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    AdminConsole adminConsole = new AdminConsole(zoo, scanner);
                    adminConsole.start();
                    break;
                case "2":
                    TicketingModule ticketingModule = new TicketingModule(zoo, scanner);
                    Visitor visitor = ticketingModule.start();
                    if (visitor != null) {
                        System.out.println("\n=== Visitor Entry ===");
                        System.out.print("Enter your ticket code: ");
                        String enteredCode = scanner.nextLine();
                        if (zoo.validateTicket(enteredCode)) {
                            System.out.println("Welcome, " + visitor.getName() + "! Enjoy your visit.");
                            VisitorModule visitorModule = new VisitorModule(visitor, zoo, scanner);
                            visitorModule.start();
                        } else {
                            System.out.println("Invalid ticket code. Entry denied.");
                        }
                    }
                    break;
                case "3":
                    System.out.println("Exiting simulation. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}