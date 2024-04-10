// StudentRepository.java
package com.driver;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private final HashMap<String, Student> studentMap = new HashMap<>();
    private final HashMap<String, Teacher> teacherMap = new HashMap<>();
    private final HashMap<String, List<String>> teacherStudentMapping = new HashMap<>();

    public void saveStudent(Student student) {
        studentMap.put(student.getName(), student);
    }

    public void saveTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(), teacher);
    }

    public void saveStudentTeacherPair(String studentName, String teacherName) {
        if (teacherStudentMapping.containsKey(teacherName)) {
            teacherStudentMapping.get(teacherName).add(studentName);
        } else {
            List<String> students = new ArrayList<>();
            students.add(studentName);
            teacherStudentMapping.put(teacherName, students);
        }
    }

    public Student findStudent(String studentName) {
        return studentMap.get(studentName);
    }

    public Teacher findTeacher(String teacherName) {
        return teacherMap.get(teacherName);
    }

    public List<String> findStudentsFromTeacher(String teacherName) {
        return teacherStudentMapping.getOrDefault(teacherName, new ArrayList<>());
    }

    public List<String> findAllStudents() {
        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacherName) {
        teacherMap.remove(teacherName);
        teacherStudentMapping.remove(teacherName);
    }

    public void deleteAllTeachers() {
        teacherMap.clear();
        teacherStudentMapping.clear();
    }
}
