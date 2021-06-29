package controller;


import util.Validation;
import entity.Student;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import util.Printer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duc Ky   
 */
public class StudentController {
    private ArrayList<Student> listStudent;
    private ArrayList<String> listCourse;
    /**
     * Public constructor
     */
    public StudentController(){
        listStudent = new ArrayList<>();
    }
    
    public StudentController(ArrayList<Student> listStudent, ArrayList<String> listCourse){
        this.listStudent = listStudent;
        this.listCourse = listCourse;
    }   
    
    /**
     * Check if student list is empty
     *
     * @return 
     */
    public boolean isEmptyList(){
        return (listStudent.isEmpty());
    }
    /**
     * Check ID is existed
     * @param id
     * @return 
     */
    public boolean isIdExisted(String id){
        for (Student student : listStudent){
            if (student.getId().compareToIgnoreCase(id) == 0){
                return true;
            }
        }
        return false;
    }
    /**
     * Check semester of this id is existed
     * @param id
     * @param semester
     * @return 
     */
    public boolean isSemesterExisted(String id, int semester){
        for (Student student : listStudent){
            if (student.getSemester() == semester && student.getId().compareToIgnoreCase(id) == 0){
                return true;
            }
        }
        return false;
    }
    public String checkValidCourse(String course){
        boolean check = false;
        for (String tmp : listCourse){
            if (tmp.compareToIgnoreCase(course) == 0){
                return tmp;
            }
        }
        return null;
    }
    public  boolean isInt(String tmp){
        try{
            if (Integer.parseInt(tmp) == Integer.parseInt(tmp)){
                return true;
            }
        }catch(Exception e){
        }
        return false;
    }
    public boolean checkValidId(String id){
        boolean check = false;
        if (isIdExisted(id)){
            System.out.println("ID is existed! Enter Again!");
            return false;
        }else if(isInt(id) && Integer.parseInt(id) <= 0){
            System.out.println("Invalid input! Enter again!");
            return false;
        }else{
            return true;
        }
    }
    public String getNameById(String id){
        for(Student student : listStudent){
            if (student.getId().compareTo(id) == 0)
                return student.getName();
        }
        return null;
    }
    public void add(Student student){
        if (student == null) return;
        String tmp = Validation.beautyName(student.getName());
        student.setName(tmp);
        student.setCourse(checkValidCourse(student.getCourse()));
        listStudent.add(student);
    }
//================================================================================================================================
    /**
     * Create new student
     */
    public void create() {
        int semester, count = listStudent.size();
        String id, name, courseName;
        char choice = 'y';
        Student newStudent = new Student();
        //Solution
        while(true){
            count++;
            while(true){
                //Enter id
                id = Validation.inputString("Student ID   : ");
                if (isIdExisted(id)){
                    Printer.displayById(listStudent, id);
                    if (Validation.checkYesNo("Do you want enter new ID?(Y/N) ")){
                        continue;
                    }
                    newStudent.setId(id);
                    newStudent.setName(getNameById(id));
                    break;
                }
                if (checkValidId(id)){
                    //Enter name
                    while(true){
                        name = Validation.inputString("Student name : ");
                        if (Validation.isLetter(name)){
                            break;
                        }else{
                            System.out.println("Enter again! ");
                        }
                    }
                    newStudent.setName(Validation.beautyName(name));
                    newStudent.setId(id);
                    break;
                }
            }
            //Enter semester
            while(true){
                semester = Validation.inputInt("Semester     : ");
                if (isSemesterExisted(id, semester)){
                    System.out.println("You have learned this semester! Enter Again!");
                }else if(semester <= 0){
                    System.out.println("Semester must be positive number! Enter Again");
                }else{
                    newStudent.setSemester(semester);
                    break;
                }
            }
            //Enter course name
            while(true){
                courseName = Validation.inputString("Course name  : ");
                if(checkValidCourse(courseName) == null){
                    System.out.println(Printer.availableCourse(listCourse));
                    System.out.println("Invalid course's name! Enter Again");
                }else{
                    newStudent.setCourse(checkValidCourse(courseName));
                    break;
                }
            }
            //Check if user want to enter more than 10 student
            if (count >= 10){
                choice = Validation.inputChar("Do you want to continue (Y/N)? Choose Y to continue, N to return main screen: ");
            }
            if (choice == 'Y' || choice == 'y') continue;
            else if (choice == 'N' || choice == 'n') break;
            else{
                System.out.println("You can only enter Y or N!");
                choice = Validation.inputChar("");
            }
        }
        listStudent.add(newStudent);
    }
//================================================================================================================================
    /**
     * Find student by name
     */
    public void find(){
        if (isEmptyList()){
            System.out.println("Create new student before excute this function!");
            return;
        }

        //Init variable
        boolean hasPrinted = false;
        String findName;
        boolean hasFound = false;
        ArrayList<Student> tmpList = new ArrayList<>();
        String [] sArray;
        //Input name to find
        System.out.println("Enter the student's name to find: ");
        findName = Validation.in.nextLine();
        if (!findName.replaceAll("\\s+", "").isEmpty() || findName.isEmpty()){
            //Solution
            for (Student student : listStudent){
                sArray = student.getName().split(" ");
                if (student.getName().toLowerCase().contains(findName.toLowerCase())){
                    tmpList.add(student);
                    hasFound = true;
                }
            }
        }else{
            tmpList = listStudent;
            sort(tmpList);
            Printer.displayAll(tmpList);
            hasFound = true;
        }
        if (!hasFound) System.out.println("\nCan not find student!");
        else sort(tmpList);
    }
//================================================================================================================================
    /**
     * Ascending sort by name
     */
    public void sort(ArrayList<Student> tmpList){
        if (isEmptyList()){
            System.out.println("Create new student before excute this function!");
            return;
        }

//        Collections.sort(tmpList, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareToIgnoreCase(o2.getName());
//            }
//        });
        System.out.println("======== List after sorting ======");
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
        Printer.displayAll(tmpList);
    }
//================================================================================================================================
    /**
     * Update student by ID
     * @param id 
     */
    public void update(String id){
        boolean hasUpdate;
        if (isEmptyList()){
            System.out.println("Create new student before excute this function!");
            return;
        } 
        int index;
        //Display information
        int countId = Printer.displayById(listStudent, id);
        if (countId == 0) return;
        
        //Process
        while (true){
            if (countId > 1){
                index = Validation.inputInt("Enter index you want to update: ");
                if (index > countId || index < 1) continue;
                hasUpdate = updateInfo(id, index);
            }else if (countId == 1){
                hasUpdate = updateInfo(id, 1);
            }else{
                hasUpdate = false;
            }
            if (hasUpdate) {
                if (Validation.checkYesNo("Do you want to update another?(Y/N): ")){
                    Printer.displayById(listStudent, id);
                }else{
                    break;
                }
            }
        }
    }
    public boolean updateInfo(String id, int index){
        //init variable
        Student newStudent = new Student();
        String name, courseName;
        int semester;
        boolean hasUpdate = false;
        int i = 1;
        boolean hasEntered = false, isCorrected;
        //process
        for(Student student: listStudent){
            if(student.getId().compareToIgnoreCase(id) == 0 && i == index){
                Printer.displayHeader();
                Printer.displayStudent(student);
                System.out.println("Leave it blank if you want to skip the update!");
                
                //Enter name
                hasEntered = false;
                System.out.print("Enter new name: ");
                while(true){
                    name = Validation.in.nextLine();
                    if (Validation.isLetter(name)){
                        break;
                    }else{
                        System.out.print("Enter again: ");
                    }
                }
                
                if (!name.replaceAll(" ", "").isEmpty() || !name.isEmpty())  //Check if enter empty or not
                    if (student.getName().compareToIgnoreCase(name) != 0){   //if enter new name is same old name, then rename all name with id by new name
                        for (Student tmp: listStudent){
                            if (tmp.getName().compareToIgnoreCase(student.getName()) == 0 && id.compareToIgnoreCase(student.getId()) == 0){
                                tmp.setName(Validation.beautyName(name));
                            }
                        }
                    }
                
                //Enter semester
                hasEntered = false;
                isCorrected = false;
                System.out.print("Semester      : ");
                String tmp = Validation.in.nextLine();
                if (!tmp.isEmpty() || !tmp.replaceAll(" ", null).isEmpty()){  //Check if enter empty or not
                    while(true){
                        if (hasEntered && isCorrected){
                            break;
                        }else if(hasEntered && !isCorrected){
                            System.out.print("Semester      : ");
                            tmp = Validation.in.nextLine();
                        }
                        if (Validation.isInt(tmp)){
                            semester = Integer.parseInt(tmp);
                            if (isSemesterExisted(id, semester)){     //check duplicate semester
                                hasEntered = true;
                                isCorrected = false;
                                System.out.println("You have learned this semester! Enter Again!");
                                continue;
                            }
                            if (semester <= 0){
                                hasEntered = true;
                                isCorrected = false;
                                System.out.println("Semester must be positive number! Enter Again");
                                continue;
                            }
                            hasEntered = true;
                            isCorrected = true;
                            student.setSemester(semester);
                        }
                    }
                }
                
                //Enter course name
                hasEntered = false;
                isCorrected = false;
                System.out.print("Course Name   : ");
                courseName = Validation.in.nextLine();
                if (!courseName.isEmpty() || !courseName.replaceAll(" ", null).isEmpty()){
                    while(true){
                        if (hasEntered && isCorrected){
                            break;
                        }else if(hasEntered && !isCorrected){
                            System.out.print("Course Name   : ");
                            courseName = Validation.in.nextLine();
                        }
                        
                        if (checkValidCourse(courseName) != null) {
                            hasEntered = true;
                            isCorrected = true;
                            student.setCourse(checkValidCourse(courseName));
                        }else{
                            hasEntered = true;
                            isCorrected = false;
                            System.out.println(Printer.availableCourse(listCourse));
                            System.out.println("Enter again!");
                        }
                    }
                }
                hasUpdate = true;
                break;
                
            }else if (student.getId().compareToIgnoreCase(id) == 0) i++;
            
        }
        if (hasUpdate) System.out.println("Update successful!");
        return hasUpdate;
    }
//================================================================================================================================
    /**
     * Delete student by ID
     * @param id 
     */
    public void delete(String id){
        int index;
        int count = Printer.displayById(listStudent, id);
        boolean isDeleted = false;
        while(true){
            if (count > 1){
                index = Validation.inputInt("Enter index you want to delete: ");
                if (index > count || index < 1) {
                    System.out.println("Invalid index|");
                    continue;
                }
                deleteStudent(id, index);
                System.out.println("Delete successfully!");
                isDeleted = true;
            }else if (count == 1){
                deleteStudent(id, 1);
                System.out.println("Delete successfully!");
            }
            if (!Validation.checkYesNo("Do you want to delete another?(Y/N): ")){
                break;
            }else{
                count = Printer.displayById(listStudent, id);
            }
        }
        
    }
    
    public void deleteStudent(String id, int index){
        int i = 1;
        Student tmp = null;
        boolean hasDetele = false;
        for (Student student : listStudent){
            if (student.getId().compareToIgnoreCase(id) == 0 && i == index){
                Printer.displayHeader();
                Printer.displayStudent(student);
                tmp = student;
                hasDetele = true;
                break;
            }else if(student.getId().compareToIgnoreCase(id) == 0) i++;
        }
        if (hasDetele) listStudent.remove(tmp);
    }
 
}


