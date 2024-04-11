package com.driver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students/add-student")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("New student added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/students/add-teacher")
    public ResponseEntity<String> addTeacher(@RequestBody Teacher teacher){
        studentService.addTeacher(teacher);
        return new ResponseEntity<>("New teacher added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/students/add-student-teacher-pair")
    public ResponseEntity<String> addStudentTeacherPair(@RequestParam String studentName, @RequestParam String teacherName){
        studentService.createStudentTeacherPair(studentName, teacherName);
        return new ResponseEntity<>("New student-teacher pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/students/get-student-by-name/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name){
        Student student = studentService.findStudent(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students/get-teacher-by-name/{name}")
    public ResponseEntity<Teacher> getTeacherByName(@PathVariable String name){
        Teacher teacher = studentService.findTeacher(name);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("/students/get-students-by-teacher-name/{teacher}")
    public ResponseEntity<List<String>> getStudentsByTeacherName(@PathVariable String teacher){
        List<String> students = studentService.findStudentsFromTeacher(teacher);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/students/get-all-students")
    public ResponseEntity<List<String>> getAllStudents(){
        List<String> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @DeleteMapping("/students/delete-teacher-by-name")
    public ResponseEntity<String> deleteTeacherByName(@RequestParam String teacher){
        studentService.deleteTeacher(teacher);
        return new ResponseEntity<>(teacher + " removed successfully", HttpStatus.OK);
    }

    @DeleteMapping("/students/delete-all-teachers")
    public ResponseEntity<String> deleteAllTeachers(){
        studentService.deleteAllTeachers();
        return new ResponseEntity<>("All teachers deleted successfully", HttpStatus.OK);
    }
}
