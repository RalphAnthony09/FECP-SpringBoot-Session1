package org.example;

import java.util.*;

public class HandlerModule {

    public static void runHandler(){
        Scanner scanner = new Scanner(System.in);

        Enclosure felineEnclosure = new Enclosure("Feline");

        Animal tiger = new Feline("Tigress",true, felineEnclosure);
        Animal lion = new Feline("lioness",true, felineEnclosure);

        System.out.println("Handler Module");

        System.out.print("Choose a handler name: ");
        String handlerName = scanner.nextLine();

        Handler handler = new Handler(handlerName, felineEnclosure);

        handler.assignAnimal(tiger);
        handler.assignAnimal(lion);

        while (true){
            handler.getAnimalsHandled();
            System.out.print("Choose animal to interact with (0 to exit): ");
            int choice = scanner.nextInt();
            if(choice == 1){
                System.out.println("\nChoose Action:");
                System.out.println("Feed " + tiger.getName());
                System.out.println("Exercise " + tiger.getName());
                System.out.println("Examine " + tiger.getName());
                System.out.println("Back");
                System.out.print("\nChoose an option: ");
                int animalChoice = scanner.nextInt();
                switch (animalChoice){
                    case 1:
                        System.out.println("Feeding " + tiger.getName());
                        tiger.eat();
                        break;
                    case 2:
                        System.out.println("Exercising " + tiger.getName());
                        tiger.exercise();
                        break;
                    case 3:
                        System.out.println("Examining " + tiger.getName());
                        break;
                    case 4:
                        break;
                }
            }
            else if(choice == 2){
                System.out.println("\nChoose Action:");
                System.out.println("Feed " + lion.getName());
                System.out.println("Exercise " + lion.getName());
                System.out.println("Examine " + lion.getName());
                System.out.println("Back");
                System.out.print("\nChoose an option: ");
                int animalChoice = scanner.nextInt();
                switch (animalChoice){
                    case 1:
                        System.out.println("Feeding " + lion.getName());
                        tiger.eat();
                        break;
                    case 2:
                        System.out.println("Exercising " + lion.getName());
                        tiger.exercise();
                        break;
                    case 3:
                        System.out.println("Examining " + lion.getName());
                        break;
                    case 4:
                        break;
                }
            } else if (choice == 0) {
                System.out.println("Finished duties for today");
                return;
            }
        }


    }


}
