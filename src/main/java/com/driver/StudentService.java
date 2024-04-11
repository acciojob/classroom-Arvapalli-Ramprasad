// StudentService.java
package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }

    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }

    public void createStudentTeacherPair(String studentName, String teacherName){
        studentRepository.saveStudentTeacherPair(studentName, teacherName);
    }

    public Student findStudent(String studentName){
        return studentRepository.findStudent(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return studentRepository.findTeacher(teacherName);
    }

    public List<String> findStudentsFromTeacher(String teacherName){
        return studentRepository.findStudentsFromTeacher(teacherName);
    }

    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void deleteTeacher(String teacherName){
        studentRepository.deleteTeacher(teacherName);
    }

    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}