/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.StudentController;
import java.util.ArrayList;
import entity.Student;

/**
 *
 * @author Duc Ky
 */
public class Menu {
    public static void menu(StudentController sl, ArrayList<Student> listStudent){
        char choice;
        //Menu
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        //Process
        while(true){
            System.out.println("1. Create");
            System.out.println("2. Find and Sort");
            System.out.println("3. Update/Delete");
            System.out.println("4. Report");
            System.out.println("5. Exit");
            choice = Validation.inputChar("Enter choice: ");
            switch(choice){
                case '1':
                    System.out.println("=========== 1. Create ==========");
                    sl.create();
                    System.out.println("==============================");
                    break;
                case '2':
                    System.out.println("=========== 2. Find and sort ==========");
                    sl.find();
                    System.out.println("=====================================");
                    break;
                case '3':
                    System.out.println("=========== 3. Update/Delete ==========");
                    String id;
                    id = Validation.inputString("Enter id want to Update/Delete: ");
                    
                    char tmp;
                    while(true){
                        tmp = Validation.inputChar("Do you want to update (U) or delete (D) student? "
                                + "\nIf user chooses U, the program allows user updating. Choose D for deleting student.\n"
                                + "Enter choice: ");
                        if(tmp == 'U' || tmp == 'u'){
                            sl.update(id);
                            break;
                        }else if(tmp == 'D' || tmp == 'd'){
                            sl.delete(id);
                            break;
                        }else{
                            System.out.println("Invalid input!");
                        }
                    }
                    System.out.println("=======================================");
                    break;
                case '4':
                    System.out.println("=========== 4. Report ==========");
                    Printer.report(listStudent);
                    System.out.println("==============================");
                    break;
                case '5':
                    break;
                case '6':
                    Printer.displayAll(listStudent);
                default:
                    System.out.println("Invalid input! Enter from 1 to 5.");
            }
            if (choice == '5') break;
            System.out.println("================ Menu ================");
        }
    } 
}
