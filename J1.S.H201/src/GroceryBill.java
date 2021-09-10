/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ducky
 */
public class GroceryBill {
    //
    Employee employee;
    
    public GroceryBill(Employee clerk){
        //ở đây thấy cái public tên class thì thấy nó là 1 constructor
        //constructor này có biến tham chiếu
        //nên nó cx là thuộc tính luôn
        this.employee = clerk;
    }
    public void add(Item i){
        
    }
    public double getTotal(){
        return 0;
    }
    public void printReceipt(){
        
    }

  
}
