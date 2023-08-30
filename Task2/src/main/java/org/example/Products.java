package org.example;

import com.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Products {

    String file = "/Users/mac/IdeaProjectsn/Task2/src/main/java/org/example/text.csv";

    CSVReader reader = new CSVReader(new FileReader(file));


    private HashMap<String, Integer> productAndPrice = new HashMap<>();

    public Products() throws FileNotFoundException {
    }

    public void items() throws IOException {
        String[] line;
        while ((line = reader.readNext()) != null) {
            String productName = line[0];
            int productQuantity = Integer.parseInt(line[3]);
            int productPrice = Integer.parseInt(line[2]);
            productAndPrice.put(productName, productPrice);


        }

        //System.out.println(productAndPrice);



    }

    public HashMap<String, Integer> getProductAndPrice() {
        return productAndPrice;
    }
}
