import Menu.Menu;

import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            Menu.displayMenu();
            choice = scanner.nextInt();
            Menu.handleUserChoice(choice);
        }while(choice != 8);
    }
}
