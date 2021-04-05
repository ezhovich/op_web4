package com.example.lab4_web;
import java.util.ArrayList;

public class Faculty {
    private static int counter = 0;
    private int id;
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public int getId() {
        return id;
    }

    public Faculty(String name) {
        id = ++counter;
        this.name = name;
    }

    public Student getStudent(String stringStudent) {
        Student student = new Student(stringStudent);
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(stringStudent))
                return currentStudent;
        }
        throw new IllegalArgumentException("student " + stringStudent
                + " is not inside the " + name);
    }

    public void addStudent(String stringStudent) {
        Student student = new Student(stringStudent);
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(stringStudent)) {
                throw new IllegalArgumentException("student " + stringStudent
                        + " is already inside the " + name);
            }
        }
        students.add(student);
    }
    public void addStudent(Student student) {
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(student.getName())) {
                throw new IllegalArgumentException("student " + student
                        + " is already inside the " + name);
            }
        }
        students.add(student);
    }

    public void removeStudent(String stringStudent) {
        Student student = new Student(stringStudent);
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(stringStudent)) {
                students.remove(currentStudent);
                return;
            }
        }
        throw new IllegalArgumentException("student " + stringStudent
                + " is not inside the " + name);
    }

    public void removeStudent(Student student) {
        for (Student currentStudent : students) {
            if (currentStudent.getName().equals(student.getName())) {
                students.remove(currentStudent);
                return;
            }
        }
        throw new IllegalArgumentException("student " + student.getName()
                + " is not inside the " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return name +
                "\n"+ this.getStudents();
    }


}
