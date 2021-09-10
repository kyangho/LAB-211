/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Task;
import java.text.ParseException;
import java.util.ArrayList;
import util.Validation;

/**
 *
 * @author Duc Ky
 */
public class TaskManager {
    public ArrayList<Task> taskList;
    private final int NOT_EXIST = -1;
    private final int EXIST = 1;
    public TaskManager() {
    }

    public TaskManager(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }
    public int addTask(String requirementName, String assignee, String reviewer, int taskTypeId, String date, double planFrom, double planTo) throws Exception{
        try{
            if (checkPlanFrom(planFrom) == NOT_EXIST){
                return NOT_EXIST;
            }
            if (checkPlanTo(planFrom, planTo) == NOT_EXIST){
                return NOT_EXIST;
            }
            taskList.add(new Task(getLastTaskId() + 1, taskTypeId, requirementName
                , date, planFrom, planTo, assignee, reviewer));
        }catch(Exception e){
            return NOT_EXIST;
        }
        return EXIST;
    }
    private double checkPlanFrom(double planFrom){
        if (planFrom >= 8 && planFrom <= 17.5){
            return planFrom;
        }
        return NOT_EXIST;
    }
    private double checkPlanTo(double planFrom, double planTo){
        if (planFrom >= planTo){
            return NOT_EXIST;
        }
        if (planTo >= 8 && planTo <= 17.5){
            return planTo;
        }
        return NOT_EXIST;
    }
    public int addTask(Task task){
        if (task == null){
            return NOT_EXIST;
        }
        task.setId(getLastTaskId() + 1);
        try{
            if (checkPlanFrom(task.getPlanFrom()) == NOT_EXIST){
                return NOT_EXIST;
            }
            if (checkPlanTo(task.getPlanFrom(), task.getPlanTo()) == NOT_EXIST){
                return NOT_EXIST;
            }
            taskList.add(task);
        }catch(Exception e){
            return NOT_EXIST;
        }
        return EXIST;
    }
    public Task deleteTask(int id){
        for (Task t : taskList){
            if (t.getId() == id){
                taskList.remove(t);
                return t;
            }
        }
        return null;
    }
    private int getLastTaskId(){
        if (taskList.size() == 0){
            return 0;
        }
        return taskList.get(taskList.size() - 1).getId();
    }
    public ArrayList<Task> getDataTasks(){
        return taskList;
    }
    public int getSizeOfData(){
        return taskList.size();
    }
}
