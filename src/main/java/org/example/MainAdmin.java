package org.example;

import java.util.*;


public class MainAdmin {

    public static boolean logIn(){

        Manager manager = new Manager("Masterchief", "Hospital","12345");

        String adminUserName = manager.getName();
        String adminPassWord = manager.getPassword();

        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter username: ");
        String userName = scanner.nextLine();

        System.out.printf("Enter password: ");
        String passWord = scanner.nextLine();

        if(userName.equals(adminUserName) && passWord.equals(adminPassWord)){
            System.out.println("Login successful. Welcome!\n");
            return true;
        }

        System.out.println("Login unsuccessful.");
        return false;
    }

    public static void setUpZoo(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Zoo Setup ---");

        System.out.printf("Enter Manager's name: ");
        String managerName = scanner.nextLine();

        System.out.printf("Enter Veterianarians's name: ");
        String veterinarianName = scanner.nextLine();

        System.out.printf("Enter Handler for Pachyderm Enclosure: ");
        String pachydermHandlerName = scanner.nextLine();

        System.out.printf("Enter Handler for Feline Enclosure: ");
        String felineHandlerName = scanner.nextLine();

        System.out.printf("Enter Handler for Bird Enclosure: ");
        String birdHandlerName = scanner.nextLine();

        System.out.printf("Enter Vendor for Ticket Shop: ");
        String ticketShopVendorName = scanner.nextLine();

        System.out.printf("Enter Vendor for Shop: ");
        String shopVendorName = scanner.nextLine();

        System.out.println("Zoo staff setup complete.");
    }

    public static void main(String[] args) {

        boolean isZooOpen;

        System.out.println("=== Welcome to the Zoo Admin Console ===");
        System.out.println("Please log in.");

        if(!logIn()){
            return;
        }

        while (true){
            Scanner scanner = new Scanner(System.in);

            System.out.println("=========== ZOO ADMIN MAIN MENU ===========");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Access Handler Module");
            System.out.println("3. Open Zoo to Visitors");
            System.out.println("4. Close Zoo to Visitors");
            System.out.println("5. Exit");

            System.out.printf("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    setUpZoo();
                    break;
                case 2:
                    break;
                case 3:
                    isZooOpen = true;
                    System.out.println("Zoo is open\n");
                    break;
                case 4:
                    isZooOpen = false;
                    System.out.println("Zoo is closed\n");
                    break;
                case 5:
                    return;
            }
        }
    }
}
