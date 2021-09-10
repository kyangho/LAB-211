/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unity;

import java.util.Date;

/**
 *
 * @author ducky
 */
public class Product {
    private int id;
    private String name;
    private String location;
    private double price;
    private Date expiryDate;
    private Date dateOfManufacture;
    private String category;
    private Storekeeper storekeeper;
    private Date receiptDate;

    public Product() {
    }

    public Product(int id, String name, String location, double price, Date expiryDate, Date dateOfManufacture, String category, Storekeeper storekeeper, Date receiptDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.expiryDate = expiryDate;
        this.dateOfManufacture = dateOfManufacture;
        this.category = category;
        this.storekeeper = storekeeper;
        this.receiptDate = receiptDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public Date getDateOfManufacture() {
        return dateOfManufacture;
    }

    public String getCategory() {
        return category;
    }

    public Storekeeper getStorekeeper() {
        return storekeeper;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }
    
}
