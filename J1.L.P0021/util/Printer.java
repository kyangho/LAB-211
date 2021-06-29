/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.Key;
import entity.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Duc Ky
 */
public class Printer {
    public static void displayAll(ArrayList<Student> listStudent){
        for (Student s: listStudent){
            displayStudent(s);
        }
    }
    //print header
    public static void displayHeader(){
        System.out.printf("%-8s|%-25s|%-8s|%-30s|\n", "ID", "NAME", "SEMESTER", "COURSE NAME");
    }
    //print student's information
    public static void displayStudent(Student student){
        System.out.printf("%-8s|%-25s|%-8d|%-30s|\n", student.getId(), student.getName(), student.getSemester(), student.getCourse());
    }
    public static String availableCourse(ArrayList<String> listCourse){
        if (listCourse.isEmpty()) return null;
        String result = "Available courses are ";
        for (String s : listCourse){
            result = result + s + ", ";
        }
        return result.substring(0, result.length() - 2);
    }
    public static void report(ArrayList<Student> listStudent){
        //Init
        Map<Key, Integer> mapCount = new HashMap<>();
        ArrayList<Student> tmpList = listStudent;
        Key key;
        //Sort tmp ArrayList
        Collections.sort(tmpList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String[] tmp1 = o1.getName().split(" ");
                String[] tmp2 = o2.getName().split(" ");
                int i = 1;
                if (tmp1.length == 0 && tmp2.length == 0) return 0;
                else if (tmp1.length == 0) return 1;
                else if (tmp2.length == 0) return -1;
                else
                    while(true){
                        int result = tmp1[tmp1.length - i].compareToIgnoreCase(tmp2[tmp2.length - i]);
                        if (result == 0){
                            if (tmp1.length - i - 1 == 0 || tmp2.length - i - 1 == 0) return result;
                            i++;
                        }else{
                            return result;
                        }
                    }
            }
        });
        Collections.sort(tmpList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String[] tmp1 = o1.getName().split(" ");
                String[] tmp2 = o2.getName().split(" ");
                int i = 1;
                if (tmp1.length == 0 && tmp2.length == 0) return 0;
                else if (tmp1.length == 0) return 1;
                else if (tmp2.length == 0) return -1;
                else
                    while(true){
                        int result = tmp1[tmp1.length - i].compareToIgnoreCase(tmp2[tmp2.length - i]);
                        if (result == 0){
                            if (tmp1.length - i - 1 == 0 || tmp2.length - i - 1 == 0) return result;
                            i++;
                        }else{
                            return result;
                        }
                    }
            }
        });
        //Count number of course
        for (Student student : tmpList){
            key = new Key(student.getId(), student.getName(), student.getCourse());
            if(mapCount.containsKey(key)){
                mapCount.put(key, mapCount.get(key) + 1);
            }else{
                mapCount.put(key, 1);
            }
        }
        //Print to console
        System.out.printf("%-6s|%-25s|%-30s|%-12s|\n","ID", "NAME", "COURSE NAME", "TOTAL COURSE");
        for (Student student : tmpList){
            for(Map.Entry<Key, Integer> entry : mapCount.entrySet()){  
                if (student.getName().equals(entry.getKey().key2) && student.getCourse().equals(entry.getKey().key3)){
                    System.out.printf("%-6s|%-25s|%-30s|%-12s|\n",student.getId(), student.getName(), student.getCourse(), entry.getValue());
                    mapCount.remove(entry.getKey());
                    break;
                }
            }
        }
    }
    public static int displayById(ArrayList<Student> listStudent, String id){
        boolean hasFound = false;
        boolean hasPrinted = false;
        int index = 1;
        for (Student student : listStudent){
            if (student.getId().compareTo(id) == 0){
                if (!hasPrinted){
                    System.out.println(id + " was registed by");
                    System.out.printf("%-5s|%-8s|%-25s|%-8s|%-30s|\n","INDEX", "ID", "NAME", "SEMESTER", "COURSE NAME");
                    hasPrinted = true;
                }
                System.out.printf("%-5d|%-8s|%-25s|%-8d|%-30s|\n",index, student.getId(), student.getName(), student.getSemester(), student.getCourse());
                index++;
                hasFound = true;
            }
        }
        if (!hasFound) {
            index = 0;
            System.out.println("ID " + id + " not found!");
        }
        return index;
    }
}
