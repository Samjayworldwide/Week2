package org.example;

import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
//        String file = "/Users/mac/IdeaProjectsn/Task2/src/main/java/org/example/text.csv";
//        BufferedReader reader = new BufferedReader((new FileReader(file)));
//        String line = "";
//        HashMap<String,Integer> productAndPrice = new HashMap<>();
//        try {
//            while((line = reader.readLine()) != null){
//                String[] row = line.split(",");
//
//                System.out.println(row[0]);
//                System.out.println(Integer.parseInt(row[2]));
//
//
//            }
//
//        }
//        catch (Exception e){
//            System.out.println("error");
//        }


Customer samuel = new Customer(12000);
samuel.buyProduct("Bread",2);
       // Products products = new Products();
        // products.items();

Cashier junior = new Cashier("samuel","max",Role.CASHIER);
junior.acceptPayment(samuel);
    }
}