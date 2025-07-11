package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        //zoo.initializeDefaultState();
        //zoo.setOpen(true);

        while (true) {
            System.out.println("\n\n=== ZOO SIMULATION MAIN MENU ===");
            System.out.println("1. Admin Module (Placeholder)");
            System.out.println("2. Ticketing Module (Placeholder)");
            System.out.println("3. Zoo Module (Your Assignment)");
            System.out.println("4. Exit Simulation");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n--> Admin Module (handled by another team member) would be called here.");
                    AdminModule.runAdminModule();
                    break;
                case "2":
                    System.out.println("\n--> Ticketing Module:");

                    ZooTicketingModule ticketingModule = new ZooTicketingModule(null, null);  // Pass appropriate arguments for visitor and ticket

                    System.out.println("1. Buy a Ticket");
                    System.out.println("2. Validate a Ticket");
                    System.out.print("Choose an option: ");
                    String ticketChoice = scanner.nextLine();

                    if (ticketChoice.equals("1")) {
                        ticketingModule.ticketShop(); // Method to purchase ticket
                    } else if (ticketChoice.equals("2")) {
                        System.out.print("Enter Ticket Code to Validate: ");
                        String ticketCode = scanner.nextLine();
                        boolean isValid = ticketingModule.ticketChecker(ticketCode);  // Check ticket validity
                        if (isValid) {
                            String visitorName = ticketingModule.getVisitorNameByTicketCode(ticketCode);
                            System.out.println("Welcome, " + visitorName + "!");
                        }
                    } else {
                        System.out.println("Invalid choice. Returning to main menu.");
                    }
                    break;
                case "3":

                    System.out.println("\nLaunching Zoo Module...");
                    Visitor mockVisitor = new Visitor("Carlos", zoo.getTicketShop());
                    mockVisitor.setAge(17);
                    mockVisitor.setTicketCode("ZOO-6743"); // A pre-validated ticket
                    zoo.addValidTicket("ZOO-6743");
                    zoo.addPerson(mockVisitor);

                    System.out.println("Welcome, " + mockVisitor.getName() + "! Enjoy your visit.");

                    //Haven't started yet:

                    //VisitorModule visitorModule = new VisitorModule(mockVisitor, zoo, scanner);
                    //visitorModule.start();
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
