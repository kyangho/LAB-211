/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.SimpleDateFormat;
import java.util.List;
import unity.Product;
import unity.Storekeeper;
import util.Validation;

/**
 *
 * @author ducky
 */
public class Printer {
    public static void displaySelectionStorekeeper(List<Storekeeper> storekeeperList){
        System.out.println("----------- Storekeeper available -----------");
        int i = 1;
        for (Storekeeper sk : storekeeperList){
            System.out.println(i + " - " + sk.getName());
            i++;
        }
    }
    public static void displayHeaderProduct(){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-3s| %-19s| %-9s| %-6s|%-12s| %-11s|%-8s|%-11s|%-11s|\n",
                "ID", "NAME", "LOCATION", "PRICE", "EXPRIRY DATE", "DOM", "CATEGORY", "STOREKEEPER", "RECEIPT DATE");
        System.out.println("---|--------------------|----------|-------|------------|------------|--------|-----------|------------|");
    }
    public static void displayProduct(Product p){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("%-3d| %-19s| %-9s| %-6s| %-11s| %-11s| %-7s| %-10s| %-11s|\n",
                p.getId(), p.getName(), p.getLocation(), Validation.format.format(p.getPrice()), sdf.format(p.getExpiryDate()),
                sdf.format(p.getDateOfManufacture()), p.getCategory(),p.getStorekeeper().getName(), sdf.format(p.getReceiptDate()));
    }
    public static void displayProductList(List<Product> productList){
        displayHeaderProduct();
        for (Product p : productList){
            displayProduct(p);
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }
    public static void displayStorekeeper(Storekeeper storekeeper){
        System.out.println("  ID  |    Storekeeper name   |");
        System.out.printf(" %-4d | %-22s|",storekeeper.getId(), storekeeper.getName());
    }
}
