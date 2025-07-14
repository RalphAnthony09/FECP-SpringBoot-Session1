package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HandlerModule {
    private static Zoo zoo;
    private static Scanner scanner;

    public  HandlerModule(Zoo zoo, Scanner scanner) {
        this.zoo = zoo;
        this.scanner = scanner;
    }

    public static void runHandler() {
        System.out.println("\n--- Handler Module ---");
        System.out.print("Enter your handler name: ");
        String handlerName = scanner.nextLine();

        Handler handler = findHandler(handlerName);
        if (handler == null) {
            System.out.println("Handler not found. Please set up staff in the Admin Module.");
            return;
        }

        System.out.println("Welcome, " + handler.getName() + "!");

        List<Animal> assignedAnimals = getAssignedAnimals(handler);
        if (assignedAnimals.isEmpty()) {
            System.out.println("You have no animals assigned to your enclosure.");
            return;
        }

        while (true) {
            System.out.println("\nAnimals assigned to you:");
            for (int i = 0; i < assignedAnimals.size(); i++) {
                System.out.println((i + 1) + ". " + assignedAnimals.get(i).getName());
            }
            System.out.print("Choose animal to interact with (0 to exit): ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                System.out.println("Finished duties for today.");
                return;
            }
            if (choice > 0 && choice <= assignedAnimals.size()) {
                interactWithAnimal(handler, assignedAnimals.get(choice - 1));
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static Handler findHandler(String name) {
        return zoo.getPeople().stream()
                .filter(p -> p instanceof Handler && p.getName().equalsIgnoreCase(name))
                .map(p -> (Handler) p)
                .findFirst()
                .orElse(null);
    }

    private static List<Animal> getAssignedAnimals(Handler handler) {
        return zoo.getAnimals().stream()
                .filter(a -> a.getLocation().equals(handler.getLocation()))
                .collect(Collectors.toList());
    }

    private static void interactWithAnimal(Handler handler, Animal animal) {
        System.out.println("\nChoose Action for " + animal.getName() + ":");
        System.out.println("1. Feed");
        System.out.println("2. Exercise");
        System.out.println("3. Back");
        System.out.print("Choose an option: ");
        String actionChoice = scanner.nextLine();

        switch (actionChoice) {
            case "1":
                handler.feed(animal);
                break;
            case "2":
                handler.exercise(animal);
                break;
            case "3":
                break;
            default:
                System.out.println("Invalid action.");
        }
    }
}
