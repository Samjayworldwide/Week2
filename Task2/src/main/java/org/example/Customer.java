package org.example;

import com.opencsv.CSVReader;
import org.example.Products;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Customer {
    private int wallet;
    private int paymentsTab;
    private int quantityTab;
    private String customerChoice;


    private HashMap<String,Integer> customerCart = new HashMap<>();
    private HashMap<String, Integer> productAndPrice = new HashMap<>();
    private HashMap<String,Integer> productAndQuantity = new HashMap<>();
    public Customer(int wallet) throws IOException {
        this.wallet = wallet;
    }
    String File = "/Users/mac/IdeaProjectsn/Task2/src/main/java/org/example/text.csv";



    //CSVWriter writer = new CSVWriter(new FileWriter(File));
    public void buyProduct(String customerProductChoice, int customerQuantityChoice){
      quantityTab = customerQuantityChoice;
      customerChoice = customerProductChoice;

        try {

            CSVReader reader = new CSVReader(new FileReader(File));
            String[] line;
            while ((line = reader.readNext()) != null) {
                String productName = line[0];
                int productQuantity = Integer.parseInt(line[3]);
                int productPrice = Integer.parseInt(line[2]);
                getProductAndQuantity().put(productName, productQuantity);
                getProductAndPrice().put(productName, productPrice);

            }
        }catch (Exception e){
            System.out.println("There was some error");
        }


        int sum = 0;
        if (getProductAndPrice().containsKey(customerProductChoice)) {
            if (getProductAndQuantity().get(customerProductChoice) > customerQuantityChoice || getProductAndQuantity().get(customerProductChoice) == customerQuantityChoice) {
                System.out.println("The unit price of the product is : " + getProductAndPrice().get(customerProductChoice) * customerQuantityChoice);
                customerCart.put(customerProductChoice, getProductAndPrice().get(customerProductChoice) * customerQuantityChoice);
                for (int eachPrice : customerCart.values()) {
                    sum += eachPrice;
                }
                System.out.println("The sum total of the current goods purchased is : " + sum);
            } else {
                System.out.println("Goods out of Stock");
            }
        } else {
            System.out.println("This product is not in our list");
        }







    }






    public void makePayments() {
        int sum = 0;
        for (int eachPrice : customerCart.values()){
            sum += eachPrice;
        }
        System.out.println("The sum total of amount to pay is: " + sum);

        if (wallet > sum){
            int remainingBalance = wallet - sum;
            System.out.println("Your purchased has been approved \n" + "Your balance remains : " + remainingBalance);
        }else if (wallet < sum){
            System.out.println("We can't proceed in approving this purchase");
        }else{
            System.out.println("your purchase has been approved you have no remaining balance");
        }








    }


















    public int getWallet() {
        return wallet;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public int getPaymentsTab() {
        return paymentsTab;
    }

    public String getCustomerChoice() {
        return customerChoice;
    }

    public int getQuantityTab() {
        return quantityTab;
    }

    public HashMap<String, Integer> getProductAndQuantity() {
        return productAndQuantity;
    }

    public HashMap<String, Integer> getProductAndPrice() {
        return productAndPrice;
    }

    public void setPaymentsTab(int paymentsTab) {
        this.paymentsTab = paymentsTab;
    }

    public HashMap<String, Integer> getCustomerCart() {
        return customerCart;
    }

    public void setCustomerCart(HashMap<String, Integer> customerCart) {
        this.customerCart = customerCart;
    }
}
