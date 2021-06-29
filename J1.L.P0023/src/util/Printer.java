/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Fruit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 *
 * @author Duc Ky
 */
public class Printer {
    public static void displayFullofFruit(Fruit fruit){
        DecimalFormat format = new DecimalFormat("0.##$");
        System.out.printf("|   %-5s| %-15s|   %-8s|      %-8d| %-11s|\n", fruit.getId(), fruit.getName(), format.format(fruit.getPrice()),fruit.getQuantity(), fruit.getOrigin());
    }
    
    public static void headerFullofFruit(){
        System.out.println("|++ ID ++|++ Fruit Name ++|++ Price ++|++ Quantity ++|++ Origin ++| ");
    }
    
    public static void displayAllOrder(Hashtable<String, ArrayList<Fruit>> orderTable){
        if (orderTable.isEmpty()){
            System.err.println("There are nothing to view!");
            return;
        }
        double total = 0, amount;
        int i;
        DecimalFormat format = new DecimalFormat("0.##$");
        
        //Display
        Enumeration names = orderTable.keys();
        ArrayList<Fruit> orderList;
        while(names.hasMoreElements()){
            String nameStr = (String) names.nextElement();
            orderList = orderTable.get(nameStr);
            total = 0;
            i = 1;
            System.out.println("Customer: " +  nameStr);
            System.out.println("Product    | Quantity | Price | Amount |");
            System.out.println("----------------------------------------");
            for (Fruit o : orderList){
                amount = o.getPrice() * o.getQuantity();
                System.out.printf("%-11s|    %-6d|  %-5s|   %-5s|\n", i + ". " +  o.getName(), o.getQuantity(), format.format(o.getPrice()), format.format(amount));
                total += amount;
                i++;
            }
            System.out.println("----------------------------------------");
            System.out.printf("%-39s|\n", "Total: " + format.format(total));
            System.out.println("----------------------------------------\n");
        }

    }
    public static void viewOrder(ArrayList<Fruit> order){
        double amount = 0;
        System.out.println("\nYour order: ");
        System.out.println("Product    | Quantity | Price | Amount  |");
        System.out.println("-----------------------------------------");
        DecimalFormat format = new DecimalFormat("0.##$");
        for (Fruit o : order){
            amount = o.getPrice() * o.getQuantity();
            System.out.printf("%-11s|    %-6d|  %-5s|   %-6s|\n", o.getName(), o.getQuantity(), format.format(o.getPrice()), format.format(amount));
        }  
    }   
    public static void displayListFruit(ArrayList<Fruit> fruitList){
        System.out.println("|++ Item ++|++ Fruit Name ++|++ Origin ++|++ Price ++|");
        int index = 1;
        DecimalFormat format = new DecimalFormat("0.##$");
        for (Fruit f : fruitList){
            System.out.printf("      %-5d| %-15s| %-11s|   %-8s|\n", index, f.getName(), f.getOrigin(), format.format(f.getPrice()));
            index++;
        }
        System.out.println("");
    }
}
