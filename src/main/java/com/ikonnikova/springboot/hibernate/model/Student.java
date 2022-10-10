package com.ikonnikova.springboot.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //фамилия
    @Column(name = "surname")
    private String surname;

    //имя
    @Column(name = "first_name")
    private String firstName;

    //отчество
    @Column(name = "second_name")
    private String secondName;

    //курс
    @Column(name = "course")
    private int course;

    //признак активности
    @Column(name = "activity")
    private boolean activity;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", course=" + course +
                ", activity='" + activity + '\'' +
                '}';
    }
//описываем связь между таблицами courses и students
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course"
            , joinColumns = @JoinColumn(name = "students_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private List<Course> courses;

    /*
    метод добавляет курс студенту
     */
    public void addCourseToStudent(Course course) {
        if(courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }
}
