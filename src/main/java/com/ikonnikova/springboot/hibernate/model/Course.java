package com.ikonnikova.springboot.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //название курса
    @Column(name = "course_name")
    private String name;

    //дата начала
    @Column(name = "start_date")
    private LocalDate startDate;

    //дата окончания
    @Column(name = "end_date")
    private LocalDate endDate;

    //признак активности
    @Column(name = "activity")
    private boolean activity;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "courses_coursecontents_mappping",
    joinColumns = @JoinColumn(name = "course_id"),
      inverseJoinColumns = @JoinColumn(name = "content_id")
    )
    private Set<CourseContents> coursecontents = new HashSet<>();

    public Course() {
    }

    public Course(String name, LocalDate startDate, LocalDate endDate, boolean activity) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.activity = activity;
    }

    public boolean isActivity() {
        return activity;
    }

    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", activity='" + activity + '\'' +
                '}';
    }



    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course"
            , joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "students_id")
    )
    public List<Student> students;


    //метод причисляет студента к опр. курсу
    public void addStudentToCourse(Student student) {
        if(students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }
}
