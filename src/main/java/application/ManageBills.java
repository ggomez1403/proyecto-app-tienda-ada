package application;

import domain.model.Bill;
import domain.model.BillItem;
import domain.model.Client;
import domain.model.Product;
import domain.enumeration.Menus;

import static application.ManageProducts.*;

public class ManageBills {

    public static void MenuBillsOptions(){

        boolean manageMoreBills = true;

        while (manageMoreBills) {
            Menus.MANAGE_BILLS_MENU.getValue();

            int choice = SuperKeyBoard.readNumber();

            switch (choice){
                case 1 -> createBill();
                case 2 -> searchBillByClient();
                case 3 -> viewAllBills();
                case 4 -> manageMoreBills = false;
                default -> System.out.println("Opción invalida. Por favor intenta de nuevo.");
            }

            if (manageMoreBills) {
                System.out.println("\nDesea gestionar mas ventas o facturas (Si/No)");
                String answer = SuperKeyBoard.readText();
                manageMoreBills = answer.equalsIgnoreCase("si");
            }
        }
    }

    public static void createBill() {
        System.out.println("Creación de una nueva factura");

        System.out.print("Nombre del cliente: ");
        String clientName = SuperKeyBoard.readText();
        System.out.print("Dirección del cliente: ");
        String clientAddress = SuperKeyBoard.readText();

        Client cliente = new Client(clientName, clientAddress);
        Bill bill = new Bill(cliente);

        boolean addMoreProducts = true;

        while (addMoreProducts) {
            System.out.println("Productos disponibles:");
            seeAllProducts();

            System.out.print("Ingrese el id del producto a agregar: ");
            int productId = SuperKeyBoard.readNumber();
            System.out.print("Cantidad: ");
            int quantity = SuperKeyBoard.readNumber();

            if (quantity >= 0) {
                Product producto = productService.findProductById(productId);

                if (producto != null) {
                    bill.addItem(producto, quantity);
                    System.out.println("******PRODUCTO AGREGADO A LA FACTURA******");
                } else {
                    System.out.println("******PRODUCTO NO ENCONTRADO******");
                }
            } else {
                System.out.println("La cantidad no puede ser negativa. Por favor, inténtelo de nuevo.");
            }

            System.out.print("¿Desea agregar otro producto? (Sí/No): ");
            String continuar = SuperKeyBoard.readText();
            addMoreProducts = continuar.equalsIgnoreCase("si");
        }
        billsArray.add(bill);

        System.out.println("\nFactura creada con exito:");
        System.out.println("***********************************");
        System.out.println(bill);
        System.out.println("***********************************");
        System.out.println("Productos comprados");

        for (BillItem item : bill.getItems()) {
            System.out.println(item.getProduct().getName() + " - " + item.getQuantity() + " unidades");
        }
        System.out.println("***********************************");
    }

    public static void viewAllBills(){
        System.out.println("Listado de todas las facturas:");
        for (Bill bill : billsArray) {
            System.out.println("***********************************");
            System.out.println(bill);
            System.out.println("***********************************");
            System.out.println("Productos comprados");

            for (BillItem item: bill.getItems()){
                System.out.println(item.getProduct().getName() + " - " + item.getQuantity() + " unidades");
            }
            System.out.println("***********************************\n");
        }
    }

    public static void searchBillByClient() {
        System.out.print("Ingrese el nombre del cliente para buscar facturas: ");
        String clientName = SuperKeyBoard.readText();

        boolean found = false;

        for (Bill bill : billsArray) {
            if (bill.getClient().getName().equalsIgnoreCase(clientName)) {
                System.out.println("***********************************");
                System.out.println("Factura encontrada:");
                System.out.println(bill);
                System.out.println("***********************************");
                System.out.println("Productos comprados");

                for (BillItem item : bill.getItems()) {
                    System.out.println(item.getProduct().getName() + " - " + item.getQuantity() + " unidades");
                }
                System.out.println("***********************************");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron facturas para el cliente: " + clientName);
        }
    }
}
