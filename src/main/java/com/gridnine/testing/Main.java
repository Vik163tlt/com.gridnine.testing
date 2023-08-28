package com.gridnine.testing;

import java.util.List;
import java.util.Scanner;

import static com.gridnine.testing.FilterMenu.filterMenu;
import static com.gridnine.testing.PrintMenu.printMenu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Список перелетов:");
        List<Flight> flights = FlightBuilder.createFlights();
        flights.forEach(System.out::println);

        while (true) {
            System.out.println("Выберите пункт меню, чтобы исключить из списка перелетов \n" +
                    "Меню:");

            printMenu();
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int menu = scanner.nextInt();
                if (menu == 0) {
                    break;
                } else if (filterMenu.containsKey(menu)) {
                    filterMenu.get(menu).accept(flights);
                }
            } else {
                scanner.next();
            }
        }
    }
}