
import util.Validation;
import controller.StudentController;
import entity.Student;
import java.util.ArrayList;
import util.Menu;


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
        ArrayList<Student> listStudent = new ArrayList<>();
        ArrayList<String> listCourse = new ArrayList<>();
        listCourse.add("Java");
        listCourse.add(".Net");
        listCourse.add("C");
        listCourse.add("C++");
        listCourse.add("C/C++");
        StudentController sl = new StudentController(listStudent, listCourse);
        sl.add(new Student("1", "TRAN DUC Ky", 3, "Java"));
        sl.add(new Student("3", "Nguyen     thi Hien Luon", 2, "C++"));
        sl.add(new Student("3", "Nguyen  thi Hien Luon", 5, "Java"));
        sl.add(new Student("4", "Vu Duc tien", 3, ".Net"));
        sl.add(new Student("4", "     vu Duc Tien    ", 1, "c++"));
        sl.add(new Student("4", "Vu Duc Tien", 2, ".net"));
        sl.add(new Student("4", "Vu Duc Tien", 4, "java"));
        sl.add(new Student("5", "Vu Duc Tien", 3, "Java"));
        sl.add(new Student("6", "Tang The Ky", 3, "Java"));
        Menu.menu(sl, listStudent);
    }
}
    