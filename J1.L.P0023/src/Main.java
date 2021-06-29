

import entity.Fruit;
import java.util.ArrayList; 
import java.util.Hashtable;
import controller.Menu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */

/**
 *
 * @author Duc Ky
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        Hashtable<String, ArrayList<Fruit>> orderTable = new Hashtable<>();
        fruitList.add(new Fruit("1", "Coconut", 4, 20, "Viet Nam"));
        fruitList.add(new Fruit("2", "Orange", 4, 30, "US"));
        fruitList.add(new Fruit("3", "Apple", 4, 10, "Thailand"));
        fruitList.add(new Fruit("4", "Grape", 4, 40, "France"));

        Menu.menu(fruitList, orderTable);
    }
}   
