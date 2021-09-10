/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.TaskManager;
import entity.Task;
import java.util.ArrayList;
import util.Validation;

/**
 *
 * @author Duc Ky
 */
public class viewTask {
    TaskManager manager;
    ArrayList<String> taskType;
    public viewTask(TaskManager manager, ArrayList<String> taskType) {
        this.manager = manager;
        this.taskType = taskType;
    }
    
    public Task inputTaskInfo(){
        String name = Validation.inputName("Requirement Name: ", true);
        Integer taskTypeId = Validation.inputIntLimit(1, 4, "Task type: ",true);
        String date = Validation.inputDate("Date: ", true);
        Double planFrom;
        Double planTo = null;
        while (true){
            planFrom = Validation.inputDoubleLimit(8, 17.5, true, "From: ");
            if ( planFrom != null && planFrom >= 17.5){
                System.err.println("From must be greater than 8 and less than 17.5");
                continue;
            }
            break;
        }
        while(true){
            planTo = Validation.inputDoubleLimit(8, 17.5, true, "To: ");
            if ( planTo != null && planFrom != null && planTo <= planFrom){
                System.err.println("From plan must be less than To plan!");
                continue;
            }
            
            break;
        }   
        
        String assignee = Validation.inputName("Assignee: " , true);
        String reviewer = Validation.inputName("Reviewer: ", true);
        if (name == null || taskTypeId == null || date == null || planFrom == null
                || planTo == null || assignee == null || reviewer == null){
            return null;
        } 
        return new Task(taskTypeId, name, date, planFrom, planTo, assignee, reviewer);
    }
    public void addNewTask(){
        System.out.println("------------Add Task---------------");
        while(true){
            Task taskTmp = inputTaskInfo();
            if (manager.addTask(taskTmp) == -1){
                System.err.println("Add new task failed!");
            }else{
                System.err.println("Add new task successful");
            }
            if (!Validation.checkYesNo("Do you want to add another task?(Y/N): ")){
                break;
            }
        }
    }
    public void deleteTask(){
        if (manager.getSizeOfData() == 0){
                System.err.println("There are not thing to delete");
                return;
        }
        displayTask();
        while (true){
            if (manager.getSizeOfData() == 0){
                System.err.println("There are not thing to delete");
                return;
            }
            Integer id = Validation.inputInteger("Enter ID want to delete: ", true, false);
            if (id == null){
                System.err.println("You don't delete anything!");
            }else{
                System.err.println("You just delete this task: ");
                Printer.headerTask();
                Printer.showTask(manager.deleteTask(id));

            }
            if (!Validation.checkYesNo("Do you to delete another task?(Y/N): ")){
                System.out.println("Delete successful!");
                break;
            }
        }
    }
    public void displayTask(){
        if (manager.getSizeOfData() == 0){
            System.err.println("There are not thing to display");
            return;
        }
        Printer.showTaskList(manager.getDataTasks(), taskType);
    }
    
    public void program(){
        while(true){
            Printer.MenuProgram();
            int choice = Validation.inputIntLimit(1, 3, "Choose option: ", false);
            switch(choice){
                case 1:
                    addNewTask();
                    break;
                case 2:
                    System.out.println("---------Del Task------");
                    deleteTask();
                    break;
                case 3:
                    displayTask();
                    break;
            }
            if (choice == 4){
                break;
            }
        }
    }
}
