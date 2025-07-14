package org.example;

import java.util.*;

public class HandlerModule {

    public static void runHandler(){
        Scanner scanner = new Scanner(System.in);

        Enclosure felineEnclosure = new Enclosure("Feline");

        System.out.println("Handler Module");

        System.out.print("Choose an option: ");
        String handlerName = scanner.nextLine();

        Handler handler = new Handler(handlerName, felineEnclosure);
    }


}
