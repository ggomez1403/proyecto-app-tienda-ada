import Bill.Bill;
import Bill.BillItem;
import Client.Client;
import Menu.Menu;
import Product.Product;

import java.util.Date;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
//        runMenu();

        Client cliente = new Client("Juan Pérez", "123 Calle Principal");

        Bill factura = new Bill(new Date(), cliente);

        Product producto1 = new Product("Producto A", "desc", 2.200, 20, "categoria", "tags");
        Product producto2 = new Product("Producto B", "desc", 2.200, 20, "categoria", "tags");


        factura.addItem(producto1, 3);
        factura.addItem(producto2, 2);


        double total = factura.calculateTotal();


        System.out.println("Número de Factura: " + factura.getBillId());
        System.out.println("Fecha: " + factura.getDate());
        System.out.println("Cliente: " + factura.getClient().getName());
        System.out.println("Dirección del Cliente: " + factura.getClient().getAddress());
        System.out.println("Detalles de la Factura:");

        for (BillItem item : factura.getItems()) {
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() + " : $" + item.calcularSubtotal());
        }

        System.out.println("Total de la Factura: $" + total);
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
