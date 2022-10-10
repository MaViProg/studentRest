package com.ikonnikova.springboot.hibernate.controller;

import com.ikonnikova.springboot.hibernate.model.Student;
import com.ikonnikova.springboot.hibernate.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    /**
    get students
    http://localhost:8080/api/v1/students
     */
    @GetMapping("students")
    public List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    /**
    get student by id
    http://localhost:8080/api/v1/student/1
     */
    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id")
                                                  Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        return ResponseEntity.ok().body(student);
    }

    /**
    save student
    http://localhost:8080/api/v1/students
     */
    @PostMapping("students")
    public Student createStudent(@RequestBody Student student) {
        return this.studentRepository.save(student);
    }

    /**
    update student
     http://localhost:8080/api/v1/students/5
     */
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        student.setSurname(studentDetails.getSurname());
        student.setFirstName(studentDetails.getFirstName());
        student.setSecondName(studentDetails.getSecondName());
        student.setCourse(studentDetails.getCourse());
        student.setActivity(studentDetails.isActivity());
        return ResponseEntity.ok(this.studentRepository.save(student));
    }

    /**
    delete student
    http://localhost:8080/api/v1/students/1
     */
    @DeleteMapping("students/{id}")
    public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + studentId));
        this.studentRepository.delete(student);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }


}
