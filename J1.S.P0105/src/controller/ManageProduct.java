/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import unity.Product;
import unity.Storekeeper;

/**
 *
 * @author ducky
 */
public class ManageProduct {
    List<Product> productList;
    List<Storekeeper> storekeeperList;
    
    public ManageProduct(List<Product> productList, List<Storekeeper> storekeeperList) {
        this.productList = productList;
        this.storekeeperList = storekeeperList;
    }
    
    public Product getProductById(int id){
        for (Product p : productList){
            if (p.getId() == id){
                return p;
            }
        }
        return null;
    }
    public Storekeeper getStorekeeperById(int id){
        for (Storekeeper sk : storekeeperList){
            if (sk.getId() == id){
                return sk;
            }
        }
        return null;
    }
    
    public boolean checkDuplicateStorekeeper(int id){
        for (Storekeeper sk : storekeeperList){
            if (sk.getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean checkDuplicateProduct(int id){
        for (Product p : productList){
            if (p.getId() == id){
                return true;
            }
        }
        return false;
    }
    
    public boolean addStorekeeper(Storekeeper sk){
        if (sk == null){
            return false;
        }
        try{
            storekeeperList.add(sk);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean addProduct(Product p){
        if (p == null){
            return false;
        }
        try{
            productList.add(p);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean updateProduct(Product product){
        int i = 0;
        for (Product p : productList){
            if (p.getId() == product.getId()){
                productList.set(i, product);
                return true;
            }
            i++;
        }
        return false;
    }
    public boolean updateStorekeeper(Storekeeper storekeeper){
        int i = 0;
        for (Storekeeper p : storekeeperList){
            if (p.getId() == storekeeper.getId()){
                storekeeperList.set(i, storekeeper);
                return true;
            }
            i++;
        }
        return false;
    }
    
    public List<Product> getProductByName(String name){
        List<Product> tmpList = new ArrayList<>();
        for (Product p : productList){
            if (p.getName().toLowerCase().contains(name.toLowerCase())){
                tmpList.add(p);
            }
        }
        return tmpList;
    }
    public List<Product> getProductByCategory(String category){
        List<Product> tmpList = new ArrayList<>();
        for (Product p : productList){
            if (p.getCategory().contains(category)){
                tmpList.add(p);
            }
        }
        return tmpList;
    }
    public List<Product> getProductByStorekeeper(String storekeeper){
        List<Product> tmpList = new ArrayList<>();
        for (Product p : productList){
            if (p.getStorekeeper().getName().contains(storekeeper)){
                tmpList.add(p);
            }
        }
        return tmpList;
    }
    public List<Product> getProductByReceiptDate(Date receiptDate){
        List<Product> tmpList = new ArrayList<>();
        for (Product p : productList){
            if (p.getReceiptDate().compareTo(receiptDate) == 0){
                tmpList.add(p);
            }
        }
        return tmpList;
    }
    public List<Product> getProductList() {
        return productList;
    }
    
    public List<Storekeeper> getStorekeeperList() {
        return storekeeperList;
    }
    
    public void sortProductByExpiryDate(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product t, Product t1){
                return t.getExpiryDate().compareTo(t1.getExpiryDate()); 
            }
        });
    }
    public void sortProductByDateOfManufacture(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product t, Product t1) {
                return t.getDateOfManufacture().compareTo(t1.getDateOfManufacture());
            }
        });
    }

    
    
}
