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

//Zoo Module
class VisitorModule {
    private Visitor visitor;
    private Zoo zoo;
    private Scanner scanner;

    public VisitorModule(Visitor visitor, Zoo zoo, Scanner scanner) {
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
            List<Animal> animals = zoo.getAnimalsInEnclosure(selectedEnclosure);
            if (!animals.isEmpty()) {
                Animal animalToSee = animals.get(0); // See the first animal
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
        Shop shop = zoo.getFoodShop(); // Simplified to one main shop
        visitor.goTo(shop);

        List<Product> products = shop.getProducts();
        List<Product> cart = new ArrayList<>();
        double total = 0;

        while(true){
            System.out.println("Available Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.printf("%d. %s - P%.2f\n", i + 1, products.get(i).getName(), products.get(i).getPrice());
            }
            System.out.print("Enter the numbers of the items you want to buy (e.g., 1 3, or 0 to finish): ");
            String[] choices = scanner.nextLine().split(" ");

            if(choices[0].equals("0")) break;

            for(String c : choices){
                int itemNum = Integer.parseInt(c) - 1;
                if(itemNum >= 0 && itemNum < products.size()){
                    Product p = products.get(itemNum);
                    cart.add(p);
                    total += p.getPrice();
                    System.out.println("Added: " + p.getName());
                }
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