package entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duc Ky
 */
public class Student {
    private String id;
    private String name;
    private int semester;
    private String course;
/*
    MVC model
    Sl: processor, controller
    principle kiss? keep it simple stupid
    controller khong co printf
    
*/
//Contructor
    public Student() {
    }

    public Student(String id, String name, int semester, String course) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }
//Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    
}
