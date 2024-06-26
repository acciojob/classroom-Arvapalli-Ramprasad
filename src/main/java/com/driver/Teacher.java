// Teacher.java
package com.driver;

public class Teacher {
    private String name;
    private int age;
    private int numberOfStudents;

    public Teacher() {}

    public Teacher(String name, int age, int numberOfStudents) {
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }
}
