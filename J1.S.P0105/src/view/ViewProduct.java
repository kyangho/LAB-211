/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ManageProduct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import unity.Product;
import unity.Storekeeper;
import util.Validation;


/**
 *
 * @author ducky
 */
public class ViewProduct {
    ManageProduct mp;

    public ViewProduct(ManageProduct mp) {
        this.mp = mp;
    }
    

    public void programMenu(){
        while (true){
            System.out.println("Main menu:\n"
                    + "1. Add Storekeeper\n"
                    + "2. Add Product\n"
                    + "3. Update Product\n"
                    + "4. Search product\n"
                    + "5. Sort Product\n"
                    + "6. Exit");
            int choice = Validation.inputIntLimit("Enter choice: ", 1, 6, false);
            switch(choice){
                case 1:
                    inputStorekeeperInfo();
                    System.out.println("");
                    break;
                case 2:
                    inputProduct();
                    System.out.println("");
                    break;
                case 3:
                    updateProduct();
                    System.out.println("");
                    break;
                case 4:
                    searchProduct();
                    System.out.println("");
                    break;
                case 5:
                    sortProductList();
                    System.out.println("");
                    break;

            }
            if (choice == 6){
                break;
            }
        }
    }
    
    
    
    private void inputStorekeeperInfo(){
        while(true){
            Integer id;
            String name;
            boolean isUpdate = false;;
            id = Validation.inputInteger("Enter storekeeper id: ", true, false);
            if (mp.checkDuplicateStorekeeper(id)){  
                System.err.println("This storekeeper id was register!");
                Printer.displayStorekeeper(mp.getStorekeeperById(id));
                if (Validation.checkYesNo("\nDo you want to update this storekeeper(Y/N): ")){
                    name = Validation.inputName("Enter storekeeper name: ", true);
                    name = Validation.beautyName(name);
                    if (mp.updateStorekeeper(new Storekeeper(id, name))){
                        System.err.println("Update successful!");
                    }else{
                        System.err.println("Update failed");
                    }
                    isUpdate = true;
                }
            }else{
                name = Validation.inputName("Enter storekeeper name: ", true);
                name = Validation.beautyName(name);
                if (mp.addStorekeeper(new Storekeeper(id, name))){
                    System.err.println("Add successful!");
                }else{
                    System.err.println("Add failed!");
                }
            }
            if (!Validation.checkYesNo("Do you want to add another storekeeper?(Y/N): ")){
                break;
            }
        }
    }
    private Product inputProductInfo(){
        Integer id;
        while (true){
            id = Validation.inputInteger("Enter product id: ", true, false);
            if (id == null){
                break;
            }
            if (!mp.checkDuplicateProduct(id.intValue())){
                break;
            }else{
                System.err.println("This product id was register!");
                Printer.displayHeaderProduct();
                Printer.displayProduct(mp.getProductById(id));
            }
        }
        String name = Validation.inputName("Enter product name: ", true);
        name = Validation.beautyName(name);
        String location = Validation.inputName("Enter location: ", true);
        location = Validation.beautyName(location);
        Double price = Validation.inputDouble("Enter price: ", true, false);
        Date expiryDate = Validation.inputDate("Enter expiry date: ", true);
        Date dateOfManufacture;
        while(true){
            dateOfManufacture = Validation.inputDate("Enter date of manufacture: ", true);
            if (expiryDate == null || dateOfManufacture == null){
                break;
            }
            if (dateOfManufacture.compareTo(expiryDate) >= 0){
                System.err.println("Date of manufacture must be early than Expiry dates!");
            }else{
                break;
            }
        }

        String category = Validation.inputName("Enter category: ", true);
        category = Validation.beautyName(category);
        Printer.displaySelectionStorekeeper(mp.getStorekeeperList());
        Integer storekeeperIndex = Validation.inputIntLimit("Choose storekeeper [1 - " + mp.getStorekeeperList().size() +  "]: ", 1, mp.getStorekeeperList().size(), true);
        Date receiptDate;
        while (true){
           receiptDate = Validation.inputDate("Enter receipt date: ", true);
            if (expiryDate == null || dateOfManufacture == null ||  receiptDate == null){
                break;
            }
            if (receiptDate.compareTo(expiryDate) <= 0 && receiptDate.compareTo(dateOfManufacture) >= 0){
                break;
            }else{
                System.err.println("Receipt Date must be between Date of manufacture and Expiry date!");
            }
        }
        Product tmpProduct;
        if (id == null || name == null || location == null || price == null||
                expiryDate == null || dateOfManufacture == null ||
                category == null || storekeeperIndex == null || receiptDate == null){
            tmpProduct = null;
        }else{
            tmpProduct = new Product(id, name, location, price, expiryDate, dateOfManufacture, category, mp.getStorekeeperList().get(storekeeperIndex - 1), receiptDate);
        }
        return tmpProduct;
    }
    private void inputProduct(){
        while(true){
            Product tmpProduct = inputProductInfo();
            if (mp.addProduct(tmpProduct)){
                Printer.displayHeaderProduct();
                Printer.displayProduct(tmpProduct);
                System.err.println("Add successful!");
            }else{
                System.err.println("Add failed!");
            }
            if (!Validation.checkYesNo("Do you want to add another product?(Y/N): ")){
                break;
            }
        }
    }
    
    private boolean updateProductById(int id){
        Product tmpProduct = mp.getProductById(id);
        Storekeeper tmpStorekeeper;
        
        if (tmpProduct == null){
            System.err.println("Can not find product with id " + id + "!");
            return false;
        }
        
        String name = Validation.inputName("Enter product name: ", true);
        if (name == null) name = tmpProduct.getName();
        name = Validation.beautyName(name);
        
        String location = Validation.inputName("Enter location: ", true);
        location = Validation.beautyName(location);
        if (location == null) location = tmpProduct.getLocation();
       
        Double price = Validation.inputDouble("Enter price: ", true, false);
        if (price == null) price = tmpProduct.getPrice();
        
        Date expiryDate = Validation.inputDate("Enter expiry date: ", true);
        if (expiryDate == null) expiryDate = tmpProduct.getExpiryDate();
        
        Date dateOfManufacture;
        while(true){
            dateOfManufacture = Validation.inputDate("Enter date of manufacture: ", true);
            if (expiryDate == null || dateOfManufacture == null){
                break;
            }
            if (dateOfManufacture.compareTo(expiryDate) >= 0){
                System.err.println("Date of manufacture must be early than Expiry dates!");
            }else{
                break;
            }
        }
        if (dateOfManufacture == null) dateOfManufacture = tmpProduct.getDateOfManufacture();
        
        String category = Validation.inputName("Enter category: ", true);
        category = Validation.beautyName(category);
        if (category == null) category = tmpProduct.getCategory();
        
        Printer.displaySelectionStorekeeper(mp.getStorekeeperList());
        Integer storekeeperIndex = Validation.inputIntLimit("Choose storekeeper [1 - 4]: ", 1, mp.getStorekeeperList().size(), true);
        if (storekeeperIndex == null) tmpStorekeeper = tmpProduct.getStorekeeper();
        else tmpStorekeeper = mp.getStorekeeperById(storekeeperIndex);
        
        Date receiptDate;
        while (true){
           receiptDate = Validation.inputDate("Enter receipt date: ", true);
            if (expiryDate == null || dateOfManufacture == null ||  receiptDate == null){
                break;
            }
            if (receiptDate.compareTo(expiryDate) <= 0 && receiptDate.compareTo(dateOfManufacture) >= 0){
                break;
            }else{
                System.err.println("Receipt Date must be between Date of manufacture and Expiry date!");
            }
        }
        if (receiptDate == null) receiptDate = tmpProduct.getReceiptDate();
        
        tmpProduct = new Product(id, name, location, price, expiryDate, dateOfManufacture, category, tmpStorekeeper, receiptDate);
        if (mp.updateProduct(tmpProduct)){
            System.err.println("Update successful!");
            return true;
        }else{
            System.err.println("Update failed");
            return false;
        }
    }
    private void updateProduct(){
        Printer.displayProductList(mp.getProductList());
        while(true){
            Integer id = Validation.inputInteger("Enter product id to update: ", true, false);
            if (id == null){
                System.err.println("You just skipped update product!");
            }else{
                updateProductById(id);
            }
            if (!Validation.checkYesNo("Do you want to update another product?(Y/N): ")){
                break;
            }
        }
    }
    
    private boolean searchProductByName(String name){
        if (name == null){
            name = "";
        }
        List<Product> tmpProductList = mp.getProductByName(name);
        if (tmpProductList.isEmpty()){
            System.err.println("Can not find product with name: " + name + "!");
            return false;
        }else{
            System.out.println("Product with name: " + "\"" + name + "\"!");
            Printer.displayProductList(tmpProductList);
            return true;
        }
    }
    private boolean searchProductByCategory(String category){
        if (category == null){
            category = "";
        }
        List<Product> tmpProductList = mp.getProductByCategory(category);
        if (tmpProductList.isEmpty()){
            System.err.println("Can not find product with category: " + "\"" + category + "\"!");
            return false;
        }else{
            System.out.println("Product with category: " + "\"" + category + "\"!");
            Printer.displayProductList(tmpProductList);
            return true;
        }
    }
    private boolean searchProductByStorekeeper(String storekeeper){
        if (storekeeper == null){
            storekeeper = "";
        }
        List<Product> tmpProductList = mp.getProductByStorekeeper(storekeeper);
        if (tmpProductList.isEmpty()){
            System.err.println("Can not find product with storekeeper: " + "\"" + storekeeper + "\"!");
            return false;
        }else{
            System.out.println("Product with storekeeper: " + "\"" + storekeeper + "\"!");
            Printer.displayProductList(tmpProductList);
            return true;
        }
    }
    private boolean searchProductByReceiptDate(Date receiptDate){
        if (receiptDate ==  null){
            Printer.displayProductList(mp.getProductList());
            return true;
        }
        List<Product> tmpProductList = mp.getProductByReceiptDate(receiptDate);
        if(tmpProductList.isEmpty()){
            System.err.println("Can not find product with storekeeper: " + "\"" + Validation.sdf.format(receiptDate) + "\"!");
            return false;
        }else{
            System.out.println("Product with storekeeper: " + "\"" + Validation.sdf.format(receiptDate) + "\"!");
            Printer.displayProductList(tmpProductList);
            return true;
        }
    }
    private void searchProduct(){
        System.out.println("Search product by: \n"
                + "1. Name\n"
                + "2. Category\n"
                + "3. Storekeeper name\n"
                + "4. Receipt date");
        switch(Validation.inputIntLimit("Enter choice: ", 1, 4, false)){
            case 1:
                String name = Validation.inputName("Enter name: ", true);
                searchProductByName(name);
                break;
            case 2:
                String category = Validation.inputName("Enter category: ", true);
                searchProductByCategory(category);
                break;
            case 3:
                String storekeeper = Validation.inputName("Enter storekeeper name: ", true);
                searchProductByStorekeeper(storekeeper);
                break;
            case 4:
                Date receiptDate = Validation.inputDate("Enter receipt date: ", true);
                searchProductByReceiptDate(receiptDate);
                break;
        }
    }
    
    private void sortProductList(){
        System.out.println("Sort product list by: \n"
                + "1. Expiry Date\n"
                + "2. Date Of Manufacture");
        switch(Validation.inputIntLimit("Enter choice: ", 1, 2, false)){
            case 1:
                System.out.println("LIST BEFORE SORTED: ");
                Printer.displayProductList(mp.getProductList());
                System.out.println("\nLIST AFTER SORTED: ");
                mp.sortProductByExpiryDate();
                Printer.displayProductList(mp.getProductList());
                break;
            case 2:
                System.out.println("LIST BEFORE SORTED: ");
                Printer.displayProductList(mp.getProductList());
                System.out.println("\nLIST AFTER SORTED: ");
                mp.sortProductByDateOfManufacture();
                Printer.displayProductList(mp.getProductList());
                break;
        }
    }
    
    
}
