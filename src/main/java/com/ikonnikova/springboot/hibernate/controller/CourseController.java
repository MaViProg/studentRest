package com.ikonnikova.springboot.hibernate.controller;

import com.ikonnikova.springboot.hibernate.model.Course;
import com.ikonnikova.springboot.hibernate.repository.CourseRepository;
import com.ikonnikova.springboot.hibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v2")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    StudentService studentService;

    /*
    http://localhost:8080/api/v2/rating/1
     */
    @GetMapping("/rating/{id}")
    public Double getRating(@PathVariable(value = "id") long studentId) {
        return studentService.getStudentRating(studentId);
    }

    /*
    getCourses
    http://localhost:8080/api/v2/courses
     */
    @GetMapping("courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /*
    get course by id
    http://localhost:8080/api/v2/courses/5
     */
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> courseById(@PathVariable(value = "id")
                                                     int courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found for this id :: " + courseId));
        return ResponseEntity.ok().body(course);
    }


    /*
    save course
     */
    @PostMapping("courses")
    public Course createCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }

    /*
    update course
  */
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") int courseId,
                                               @RequestBody Course courseDetails) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + courseId));
        course.setStartDate(courseDetails.getStartDate());
        course.setEndDate(courseDetails.getEndDate());
        course.setName(courseDetails.getName());
        course.setActivity(courseDetails.isActivity());
        return ResponseEntity.ok(this.courseRepository.save(course));
    }

    /*
    delete course
     */
    @DeleteMapping("course/{id}")
    public Map<String, Boolean> deleteCourse(@PathVariable(value = "id") int courseId) {

        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + courseId));
        this.courseRepository.delete(course);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }


}

