package ui;

import infrastructure.dao.BillDAO;
import infrastructure.dto.BillDTO;
import infrastructure.dao.ClientDAO;
import infrastructure.dao.ProductDAO;
import domain.enumeration.Menus;
import domain.model.Bill;
import domain.model.BillDetail;
import domain.model.Client;
import domain.model.Product;
import domain.service.*;
import domain.service.interfaces.BillServiceInterface;
import domain.service.interfaces.ClientServiceInterface;
import domain.service.interfaces.ProductServiceInterface;
import input.SuperKeyBoard;
import infrastructure.repository.BillRepository;
import infrastructure.repository.ClientRepository;
import infrastructure.repository.ProductRepository;

import java.util.List;

public class ManageBills {
    static BillDAO billDAO = new BillDAO();
    static BillRepository billRepository = new BillRepository(billDAO);
    static BillServiceInterface billService = new BillService(billRepository);

    static ClientDAO clientDAO = new ClientDAO();
    static ClientRepository clientRepository = new ClientRepository(clientDAO);
    static ClientServiceInterface clientService = new ClientService(clientRepository);

    static ProductDAO productDAO = new ProductDAO();
    static ProductRepository productRepository = new ProductRepository(productDAO);
    static ProductServiceInterface productService = new ProductService(productRepository);

    public static void MenuBillsOptions() {

        boolean manageMoreBills = true;

        while (manageMoreBills) {
            Menus.MANAGE_BILLS_MENU.getValue();

            int choice = SuperKeyBoard.readNumber();

            switch (choice) {
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
        System.out.print("Ingrese el nombre del cliente: ");
        String clientName = SuperKeyBoard.readText();

        System.out.print("Ingrese la direccion del cliente: ");
        String clientAddress = SuperKeyBoard.readText();

        Client client = new Client(clientName, clientAddress);

        clientService.addClient(client);

        Bill bill = new Bill(client);
        billService.insertBill(bill);

        List<Product> availableProducts = productService.getAllProducts();

        if(availableProducts.isEmpty()){
            System.out.println("No hay productos disponibles. La factura no se puede crear");
            return;
        }

        do{
            System.out.println("Productos disponibles: ");
            ManageProducts.getAllProducts();

            System.out.print("Ingrese el ID del producto que desea agregar:");
            int productId = SuperKeyBoard.readNumber();

            System.out.println("Ingrese la cantidad de productos que desea agregar");
            int quantity = SuperKeyBoard.readNumber();
            Product product = productService.getProductById(productId);

            BillDetail billDetail = new BillDetail(product, quantity);
            billService.insertBillDetail(bill.getId(), billDetail);

            System.out.print("¿Desea agregar mas productos? (Sí/No): ");
            String answer = SuperKeyBoard.readText().toLowerCase();

            if(!answer.equals("si")) break;
        }while(true);
    }

    public static void searchBillByClient() {
        System.out.print("Ingrese el nombre del cliente para buscar facturas: ");
        String clientName = SuperKeyBoard.readText();

        Client client = clientService.getClientByName(clientName);

        if (client == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        List<Bill> bills = billService.getBillsByClient(client);

        if (bills.isEmpty()) {
            System.out.println("No hay facturas para el cliente: " + clientName);
        } else {
            System.out.println("Facturas para el cliente " + clientName + ":");
            for (Bill bill : bills) {
                System.out.println(bill);
            }
        }
    }

    public static void viewAllBills() {
        List<BillDTO> allBills = billService.getAllBills();

        if (allBills.isEmpty()) {
            System.out.println("No hay facturas disponibles.");
        } else {
            System.out.println("Todas las facturas:");
            for (BillDTO bill : allBills) {
                System.out.println(bill);
            }
        }
    }
}
