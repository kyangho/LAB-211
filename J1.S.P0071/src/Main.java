
import controller.TaskManager;
import entity.Task;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import util.Validation;
import view.viewTask;

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
        ArrayList<Task> taskList = new ArrayList<>();
        TaskManager tc = new TaskManager(taskList);
        tc.addTask(new Task(1, "a", "23-05-2021", 13, 17, "Dev", "Lead"));
        tc.addTask(new Task(2, "b", "25-03-2021", 10, 14, "Dev", "Lead"));
        tc.addTask(new Task(3, "c", "12-02-2021", 9, 13, "Dev", "Lead"));
        tc.addTask(new Task(2, "d", "3-07-2021", 9.5, 12, "Dev", "Lead"));
        tc.addTask(new Task(1, "e", "15-01-2021", 11, 15, "Dev", "Lead"));
        tc.addTask(new Task(3, "f", "13-02-2021", 9, 17, "Dev", "Lead"));
        
        viewTask vt = new viewTask(tc);
        vt.program();
    }
}
