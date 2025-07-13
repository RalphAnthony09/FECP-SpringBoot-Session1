package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("\n\n=== ZOO SIMULATION MAIN MENU ===");
            System.out.println("1. Admin Module");
            System.out.println("2. Ticketing Module");
            System.out.println("3. Zoo Module");
            System.out.println("4. Exit Simulation");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    AdminModule adminModule = new AdminModule(zoo, scanner);
                    adminModule.runAdminModule();
                    break;
                case "2":
                    ZooTicketingModule ticketingModule = new ZooTicketingModule(zoo, scanner);
                    ticketingModule.ticketShop();
                    break;
                case "3":
                    System.out.println("\n--> To use the Zoo Module, a visitor must first have a valid ticket.");
                    System.out.print("--> Enter a ticket code to proceed: ");
                    String ticketCode = scanner.nextLine();

                    if (zoo.isTicketValid(ticketCode)) {
                        Visitor visitor = zoo.getVisitorByTicket(ticketCode);
                        System.out.println("\nWelcome, " + visitor.getName() + "! Enjoy your visit.");
                        ZooModule zooModule = new ZooModule(visitor, zoo, scanner);
                        zooModule.start();
                    } else {
                        System.out.println("Invalid ticket. Please get a ticket from the Ticketing Module first.");
                    }
                    break;
                case "4":
                    System.out.println("Exiting simulation. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
