
import controller.ManageProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import unity.Product;
import unity.Storekeeper;
import util.Validation;
import view.Printer;
import view.ViewProduct;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ducky
 */ 
public class Main {
    public static void main(String[] args) throws ParseException{
        List<Storekeeper> storekeeperList = new ArrayList<>();
        storekeeperList.add(new Storekeeper(1, "Panda"));
        storekeeperList.add(new Storekeeper(2, "Horse"));
        storekeeperList.add(new Storekeeper(3, "Orange"));
        storekeeperList.add(new Storekeeper(4, "Family"));
        List<Product> productList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        productList.add(new Product(1, "Laptop", "US", 100, sdf.parse("01-01-2022"), sdf.parse("12-01-2020"), "Device", storekeeperList.get(0), sdf.parse("12-05-2021")));
        productList.add(new Product(2, "Personal Computer", "Vietnam", 150, sdf.parse("30-07-2022"), sdf.parse("01-05-2020"), "Device", storekeeperList.get(1), sdf.parse("27-06-2021")));
        productList.add(new Product(3, "Mobile", "Italia", 80, sdf.parse("27-02-2022"), sdf.parse("12-08-2020"), "Device", storekeeperList.get(2), sdf.parse("15-02-2021")));
        productList.add(new Product(4, "Juice", "England", 20, sdf.parse("09-09-2022"), sdf.parse("16-02-2020"), "Device", storekeeperList.get(3), sdf.parse("21-01-2021")));
        productList.add(new Product(5, "House", "France", 600, sdf.parse("12-05-2022"), sdf.parse("29-01-2020"), "Device", storekeeperList.get(1), sdf.parse("01-09-2021")));
        productList.add(new Product(6, "Car", "Japan", 300, sdf.parse("20-10-2022"), sdf.parse("30-09-2020"), "Device", storekeeperList.get(1), sdf.parse("07-10-2021")));
        productList.add(new Product(7, "Gaming Mouse", "Korean", 50, sdf.parse("15-06-2022"), sdf.parse("12-03-2020"), "Device", storekeeperList.get(0), sdf.parse("11-02-2021")));
        ManageProduct mp = new ManageProduct(productList, storekeeperList);
        ViewProduct vp = new ViewProduct(mp);
        vp.programMenu();
    }
}
