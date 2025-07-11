/*
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
            // Show a representative animal for each enclosure
            List<Animal> animalsInEnclosure = zoo.getAnimalsInEnclosure(enclosures.get(i));
            String animalExample = animalsInEnclosure.isEmpty() ? "Empty" : animalsInEnclosure.get(0).getName();
            System.out.println((i + 1) + ". " + enclosures.get(i).getName() + " (" + animalExample + ")");
        }
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(scanner.nextLine()) - 1;

        if (choice >= 0 && choice < enclosures.size()) {
            Enclosure selectedEnclosure = enclosures.get(choice);
            visitor.goTo(selectedEnclosure);
            List<Animal> animals = zoo.getAnimalsInEnclosure(selectedEnclosure);
            if (!animals.isEmpty()) {
                Animal animalToSee = animals.get(new Random().nextInt(animals.size()));
                System.out.println("You see " + animalToSee.getName() + "!");
                animalToSee.makeSound();
                System.out.print("Would you like to feed " + animalToSee.getName() + "? (yes/no): ");
                if (scanner.nextLine().equalsIgnoreCase("yes")) {
                    animalToSee.eat();
                }
            } else {
                System.out.println("This enclosure is empty right now.");
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void visitShop() {
        System.out.println("\n=== \uD83D\uDED2 Zoo Shop ===");
        Shop shop = zoo.getFoodShop();
        visitor.goTo(shop);

        List<Product> products = shop.getProducts();
        List<Product> cart = new ArrayList<>();
        double total = 0;

        while(true){
            System.out.println("Available Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s - P%.2f\n", i + 1, products.get(i).getName(), products.get(i).getPrice());
            }
            System.out.print("Enter the number of the item you want to buy (or 0 to finish): ");
            int choice = Integer.parseInt(scanner.nextLine());

            if(choice == 0) break;

            int itemNum = choice - 1;
            if(itemNum >= 0 && itemNum < products.size()){
                Product p = products.get(itemNum);
                cart.add(p);
                total += p.getPrice();
                System.out.println("Added: " + p.getName());
            } else {
                System.out.println("Invalid item number.");
            }
        }

        if(cart.isEmpty()) return;

        System.out.println("\nSelected:");
        for(Product p : cart){
            System.out.printf("- %s (P%.2f)\n", p.getName(), p.getPrice());
        }
        System.out.printf("Total: P%.2f\n", total);
        System.out.print("Proceed to checkout? (yes/no): ");
        if(scanner.nextLine().equalsIgnoreCase("yes")){
            System.out.println("Payment successful!");
            System.out.println("Receipt:");
            for(Product p : cart){
                System.out.printf("- %s: P%.2f\n", p.getName(), p.getPrice());
            }
            System.out.printf("Total Paid: P%.2f\n", total);
        } else {
            System.out.println("Purchase cancelled.");
        }
    }

    private void visitHospital() {
        Hospital hospital = zoo.getHospital();
        visitor.goTo(hospital);
        Veterinarian vet = zoo.getVeterinarian();

        while (true) {
            System.out.println("\n=== \uD83C\uDFE5 Zoo Visitor Hospital Monitor ===");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\n* Sick Animals Currently in Hospital:");
                    List<Animal> sick = hospital.getSickAnimals();
                    if(sick.isEmpty()) System.out.println("- None");
                    else sick.forEach(a -> System.out.println("- " + a.getName()));
                    break;
                case "2":
                    System.out.println("\n\u2695 Healed Animals with Timestamps:");
                    List<String> healedLog = hospital.getHealedAnimalLog();
                    if(healedLog.isEmpty()) System.out.println("- None");
                    else healedLog.forEach(System.out::println);
                    break;
                case "3":
                    if(vet != null) vet.lecture();
                    else System.out.println("There is no veterinarian available for a lecture today.");
                    break;
                case "4":
                    System.out.println("Exiting Zoo Vet Hospital. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
*/
