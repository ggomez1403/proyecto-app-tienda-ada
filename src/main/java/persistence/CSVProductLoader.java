package persistence;

import domain.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class CSVProductLoader {
    public static void loadProductsFromCSV(String csvFilePath, ProductsArray productService) {
        try (FileReader reader = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {
            for (CSVRecord csvRecord : csvParser) {
                String name = csvRecord.get("Nombre");
                String description = csvRecord.get("Descripcion");
                String categories = csvRecord.get("Categoria");
                String tags = csvRecord.get("Etiquetas");
                String priceStr = csvRecord.get("Precio");

                double price = 0.0;
                if(!priceStr.isEmpty()){
                    price = Double.parseDouble(priceStr);
                }

                String photoUrl = csvRecord.get("URL FOTO");
                Random random = new Random();
                int stock = random.nextInt(101);

                Product product = new Product(name, description, price, stock, categories, tags, photoUrl);

                productService.addProduct(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
