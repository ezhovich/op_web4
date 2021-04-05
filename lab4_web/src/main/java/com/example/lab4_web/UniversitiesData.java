package com.example.lab4_web;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniversitiesData {
    private static UniversitiesData instance;
    private Set<University> universities = new HashSet<>();

    private UniversitiesData() {
    }


    public static UniversitiesData getInstance() {
        if (instance == null) {
            instance = new UniversitiesData();
        }
        return instance;
    }

    public void addUniversity(University universityToAdd) {
        for (University univ : universities) {
            if (univ.getName().equals(universityToAdd.getName())) {
                return;
            }
        }
        universities.add(universityToAdd);
    }

    public void addFaculty(int universityId, Faculty facultyToAdd) {
        for (University univ : universities) {
            if ((univ.getId() == universityId) && (!univ.getFacultiesNames().contains(facultyToAdd.getName()))) {
                univ.addFaculty(facultyToAdd.getName());
                return;
            }
        }
    }

    public void addStudent(int uId, int fId, Student studentToAdd) {
        for (University univ : universities) {
            if (univ.getId() == uId) {
                for (Faculty fac : univ.getFaculties()) {
                    if (fac.getId() == fId) {
                        fac.addStudent(studentToAdd);
                        return;
                    }
                }
            }
        }

    }

    public void removeStudent(University universityToRemove, Faculty facultyToRemove, Student studentToRemove) {
        for (University univ : universities) {
            if (univ.getName().equals(universityToRemove.getName())) {
                for (Faculty fac : univ.getFaculties()) {
                    if (fac.getName().equals(facultyToRemove.getName())) {
                        fac.removeStudent(studentToRemove);
                        return;
                    }
                }
            }
        }
    }


    public void removeUniversity(University univ) {
        universities.remove(univ);

    }

    public University getUniversityById(int id) {
        for (University u : universities) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public Faculty getFacultyById(int universityId, int facultyId) {
        for (University u : universities) {
            if (u.getId() == universityId) {
                for (Faculty f : u.getFaculties()) {
                    if (f.getId() == facultyId) {
                        return f;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<String[]> getInfo(University universityToGet) {
        ArrayList<String[]> results = new ArrayList<>();
        ArrayList<Faculty> resFacs = universityToGet.getFaculties();
        for (Faculty fac : resFacs) {
            ArrayList<Student> facStudents = fac.getStudents();
            for (Student std : facStudents) {
                String[] tmp = new String[2];
                tmp[0] = fac.getName();
                tmp[1] = std.getName();
                results.add(tmp);
            }
        }
        return results;
    }


    public Set<University> getUniversities() {
        return universities;
    }

    public boolean hasUniversity(String universityName) {
        for (University un : universities) {
            if (un.getName().equals(universityName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFaculty(int universityId, String facultyName) {
        for (University un : universities) {
            if (un.getId() == universityId) {
                for (Faculty f : un.getFaculties()) {
                    if (f.getName().equals(facultyName)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasStudent(int universityId, int facultyId, String studentName) {
        for (University un : universities) {
            if (un.getId() == universityId) {
                for (Faculty f : un.getFaculties()) {
                    if (f.getId() == facultyId){
                        for(Student s: f.getStudents()){
                            if(s.getName().equals(studentName)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void removeFaculty(University university, Faculty faculty) {
        university.removeFaculty(faculty.getName());
    }

    public Student getStudentById(int uniId, int facId, int stdId) {
        for (University u : universities) {
            if (u.getId() == uniId) {
                for (Faculty f : u.getFaculties()) {
                    if (f.getId() == facId) {
                        for(Student s: f.getStudents()){
                            if(s.getId() == stdId){
                                return s;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
}
