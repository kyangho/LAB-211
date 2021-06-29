/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Task;
import java.util.ArrayList;

/**
 *
 * @author Duc Ky
 */
public class Printer {
    public static void showTaskList(ArrayList<Task> taskList){
        System.out.println("------------------------------------- Task -----------------------------------");
        System.out.println("ID   Name         Task Type      Date         Time      Assignee      Reviewer");
        for (Task t : taskList){
            System.out.printf("%-5s%-13s%-15s%-13s%-10s%-14s%-8s\n", t.getId(), t.getName(), t.getTaskTypeId(), t.getDate()
            ,t.getPlanTo() - t.getPlanFrom(), t.getAssignee(), t.getReviewer());
        }
    }
    public static void MenuProgram(){
        System.out.println("========= Task program =========\n" +
                            "1. Add Task\n" +
                            "2. Delete task\n" +
                            "3. Display Task\n" +
                            "4. Exit");
    }
    public static void headerTask(){
        System.out.println("ID   Name         Task Type      Date         Time      Assignee      Reviewer");
    }
    public static void showTask(Task task){
        System.out.printf("%-5s%-13s%-15s%-13s%-10s%-14s%-8s\n", task.getId(), task.getName(), task.getTaskTypeId(), task.getDate()
        ,task.getPlanTo() - task.getPlanFrom(), task.getAssignee(), task.getReviewer());
        
    }
}   
