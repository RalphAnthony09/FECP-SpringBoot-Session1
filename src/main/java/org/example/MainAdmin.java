package org.example;

import java.util.*;


public class MainAdmin {

    public static boolean logIn(){

        String adminUserName = "admin";
        String adminPassWord = "admin";

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

    //public static void

    public static void main(String[] args) {

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
                case 5:
                    return;
            }
        }
    }
}
