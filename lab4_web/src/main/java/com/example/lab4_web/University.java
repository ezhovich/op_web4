package com.example.lab4_web;

import java.util.ArrayList;
import java.util.Objects;


public class University {
    private static int counter = 0;
    private int id;
    private String name;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public int getId() {
        return id;
    }

    public University(String name) {
        id = ++counter;
        this.name = name;
    }


    public void addFaculty(String stringFaculty) {
        Faculty faculty = new Faculty(stringFaculty);
        for (Faculty currentFaculty : faculties) {
            if (currentFaculty.getName().equals(stringFaculty))
                throw new IllegalArgumentException("faculty " + faculty +
                        " is already inside the " + name);
        }
        faculties.add(faculty);
    }

    public void removeFaculty(String stringFaculty) {
        Faculty faculty = new Faculty(stringFaculty);
        for (Faculty currentFaculty : faculties) {
            if (currentFaculty.getName().equals(stringFaculty)) {
                faculties.remove(currentFaculty);
                return;
            }
        }
        throw new IllegalArgumentException("faculty " + faculty +
                " is not inside the " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Faculty> getFaculties() {
        return faculties;
    }

    public ArrayList<String> getFacultiesNames() {
        ArrayList<String> res = new ArrayList<>();
        for (Faculty fac : faculties) {
            res.add(fac.getName());
        }
        return res;
    }



    public void setFaculties(ArrayList<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
