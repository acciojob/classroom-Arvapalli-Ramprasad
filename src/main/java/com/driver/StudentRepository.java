
// StudentRepository.java
package com.driver;

import java.util.HashSet;
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
        if(studentMap.containsKey(studentName) && teacherMap.containsKey(teacherName)) {
            List<String> currentStudents = new ArrayList<String>();
            if (teacherStudentMapping.containsKey(teacherName)) {
                currentStudents = teacherStudentMapping.get(teacherName);
            }
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
        List<String> student = new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacherName)){
            student = teacherStudentMapping.get(teacherName);
            for(String s :student){
                if(studentMap.containsKey(s)){
                    studentMap.remove(student);
                }
            }
            teacherStudentMapping.remove(teacherName);
        }
        if(teacherMap.containsKey(teacherName)){
            teacherMap.remove(teacherName);
        }
    }

    public void deleteAllTeachers() {
        HashSet<String> studentsSet = new HashSet<String>();

        for(String teacher: teacherStudentMapping.keySet()){

            for(String student: teacherStudentMapping.get(teacher)){

                studentsSet.add(student);

            }

        }

        for(String student: studentsSet){

            if(studentMap.containsKey(student)){

                studentMap.remove(student);

            }

        }

    }

}
