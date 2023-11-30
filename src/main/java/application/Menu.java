package application;

import domain.enumeration.Menus;
import input.SuperKeyBoard;

import static ui.ManageProducts.*;
import static ui.ManageBills.*;

public class Menu {

    public static void runMenu() {
        int choice;
        do {
            Menu.displayMenu();
            choice = SuperKeyBoard.readNumber();
            Menu.handleUserChoiceMainMenu(choice);
        } while (choice != 3);
    }

    public static void displayMenu(){
        Menus.MAIN_MENU.getValue();
    }

    public static void handleUserChoiceMainMenu(int choice) {
        switch (choice) {
            case 1 -> MenuProductsOptions();
            case 2 -> MenuBillsOptions();
            case 3 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
        }
    }
}
