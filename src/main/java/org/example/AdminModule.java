package org.example;

import java.util.Scanner;

public class AdminModule {
    private Zoo zoo;
    private Scanner scanner;
    private Manager manager;

    public AdminModule(Zoo zoo, Scanner scanner) {
        this.zoo = zoo;
        this.scanner = scanner;
        this.manager = new Manager("Masterchief", null, "12345");
        this.zoo.addPerson(this.manager); // Ensure manager is in the zoo's list
    }

    public void runAdminModule() {
        System.out.println("\n=== Welcome to the Zoo Admin Console ===");
        System.out.println("Please log in.");

        if (!logIn()) {
            return;
        }

        while (true) {
            System.out.println("\n=========== ZOO ADMIN MAIN MENU ===========");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Open Zoo to Visitors");
            System.out.println("3. Close Zoo to Visitors");
            System.out.println("4. Exit Admin Module");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    setUpZoo();
                    break;
                case "2":
                    manager.openZoo(zoo);
                    break;
                case "3":
                    manager.closeZoo(zoo);
                    break;
                case "4":
                    System.out.println("Returning to main menu.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private boolean logIn() {
        System.out.print("Enter username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String passWord = scanner.nextLine();

        if (userName.equals(manager.getName()) && manager.getPassword().equals(passWord)) {
            System.out.println("Login successful. Welcome!\n");
            return true;
        }
        System.out.println("Login unsuccessful.");
        return false;
    }

    private void setUpZoo() {
        System.out.println("\n--- Zoo Setup ---");
        System.out.print("Enter Veterinarian's name: ");
        String vetName = scanner.nextLine();
        zoo.addPerson(new Veterinarian(vetName, zoo.getBuildingByName("Animal Hospital")));

        System.out.print("Enter Handler for Pachyderm Enclosure: ");
        String pHandlerName = scanner.nextLine();
        zoo.addPerson(new Handler(pHandlerName, zoo.getBuildingByName("Pachyderm Enclosure")));

        System.out.print("Enter Handler for Feline Enclosure: ");
        String fHandlerName = scanner.nextLine();
        zoo.addPerson(new Handler(fHandlerName, zoo.getBuildingByName("Feline Enclosure")));

        System.out.print("Enter Handler for Bird Enclosure: ");
        String bHandlerName = scanner.nextLine();
        zoo.addPerson(new Handler(bHandlerName, zoo.getBuildingByName("Bird Enclosure")));

        System.out.print("Enter Vendor for Ticket Shop: ");
        String tsVendorName = scanner.nextLine();
        zoo.addPerson(new Vendor(tsVendorName, zoo.getBuildingByName("Ticket Shop")));

        System.out.print("Enter Vendor for Food Shop: ");
        String fsVendorName = scanner.nextLine();
        zoo.addPerson(new Vendor(fsVendorName, zoo.getBuildingByName("Food Shop")));

        System.out.println("Zoo staff setup complete.");
    }
}
