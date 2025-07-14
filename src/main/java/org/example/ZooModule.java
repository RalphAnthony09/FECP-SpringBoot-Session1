package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ZooModule {
    private Visitor visitor;
    private Zoo zoo;
    private Scanner scanner;

    public ZooModule(Visitor visitor, Zoo zoo, Scanner scanner) {
        this.visitor = visitor;
        this.zoo = zoo;
        this.scanner = scanner;
    }

    public void start() {
        if (!zoo.isOpen()) {
            System.out.println("Sorry, the zoo is currently closed.");
            return;
        }
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Shop");
            System.out.println("3. Visit Hospital");
            System.out.println("4. Leave Zoo");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    visitEnclosure();
                    break;
                case "2":
                    visitShop();
                    break;
                case "3":
                    visitHospital();
                    break;
                case "4":
                    System.out.println("You have left the zoo. \uD83D\uDC4B");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void visitEnclosure() {
        System.out.println("\n==Zoo Enclosure==");
        System.out.println("Choose Enclosure:");
        List<Enclosure> enclosures = zoo.getEnclosures();
        for (int i = 0; i < enclosures.size(); i++) {
            System.out.println((i + 1) + ". " + enclosures.get(i).getName());
        }
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice >= 0 && choice < enclosures.size()) {
            Enclosure selectedEnclosure = enclosures.get(choice);
            visitor.goTo(selectedEnclosure);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void visitShop() {
        System.out.println("\nVisiting the shop...");
    }

    private void visitHospital() {
        System.out.println("\nVisiting the hospital...");

        boolean inHospital = true;

        System.out.println("=== Zoo Visitor Hospital Monitor ===");
        System.out.println("1. View Sick Animals");
        System.out.println("2. View Healed Animals");
        System.out.println("3. Attend Science Lecture");
        System.out.println("4. Heal Animals (Veterinarian)");
        System.out.println("5. Exit");

        while(inHospital!=false) {

            System.out.printf("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Sick Animals Currently in Hospital:");
                    System.out.println("- Dumbo");
                    System.out.println("- Simba");
                    break;
                case 2:
                    System.out.println("Healed Animals with Timestamps:");
                    System.out.println("- Dumbo (2025-07-08 08:27:41)");
                    System.out.println("- Simba (2025-07-08 08:27:41)");
                    break;
                case 3:
                    System.out.println("Dr. Ellie gives a science lecture on animal health and conservation.");
                    break;
                case 4:
                    System.out.println("Dr. Ellie begins healing sick animals...");
                    System.out.println("Healed: Dumbo");
                    System.out.println("Dumbo has been discharged and returned to enclosure.");
                    System.out.println("Healed: Simba");
                    System.out.println("Simba has been discharged and returned to enclosure.");
                    break;
                case 5:
                    System.out.println("Exiting Zoo Vet Hospital. Goodbye!");
                    inHospital = false;
                    break;
            }
        }
    }
}
