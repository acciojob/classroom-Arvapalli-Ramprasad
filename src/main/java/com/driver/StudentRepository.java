package com.driver;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)) {
            List<String> currentStudents = teacherStudentMapping.getOrDefault(teacherName, new ArrayList<>());
            currentStudents.add(studentName);
            teacherStudentMapping.put(teacherName, currentStudents);
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
        if (teacherStudentMapping.containsKey(teacherName)) {
            for (String student : teacherStudentMapping.get(teacherName)) {
                studentMap.remove(student);
            }
            teacherStudentMapping.remove(teacherName);
        }
        teacherMap.remove(teacherName);
    }

    public void deleteAllTeachers() {
        for(String teacher :teacherMap.keySet(){
            for (String student : teacherStudentMapping.get(teacher)) {
                
                studentMap.remove(student);
            }
            teacherStudentMapping.remove(teacher);
            teacherMap.remove(teacher);
        }
    }
}
