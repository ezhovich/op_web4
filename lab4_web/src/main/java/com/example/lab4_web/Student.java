package com.example.lab4_web;
import java.util.ArrayList;

public class Student {
    private static int counter = 0;
    private int id;

    private String name;

    public Student(String name) {
        id = ++counter;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
