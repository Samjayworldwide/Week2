package org.example;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Cashier extends StoreStaff implements CashierServices {


    //private HashMap<String,Integer> productAndQuantity = new HashMap<>();
    public Cashier(String firstName, String lastName, Role role) {
        super(firstName, lastName, role);
    }

    @Override
    public void acceptPayment(Customer customer) {
        String File = "/Users/mac/IdeaProjectsn/Task2/src/main/java/org/example/text.csv";
        int currentQuantity =  customer.getProductAndQuantity().get(customer.getCustomerChoice()) - customer.getQuantityTab();
       customer.getProductAndQuantity().put(customer.getCustomerChoice(),currentQuantity);
        try {
              CSVWriter writer = new CSVWriter(new FileWriter(File));

                for (Map.Entry<String, Integer> entry : customer.getProductAndQuantity().entrySet()) {

                    String productName = entry.getKey();
                    String updatedQuantity = String.valueOf(entry.getValue());
                    writer.writeNext(new String[]{productName, updatedQuantity});


                }


            writer.close();
        }
        catch (Exception e){
            System.out.println("error found");
        }


    }

    @Override
    public void issueReceipt() {

    }
}
