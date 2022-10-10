package com.ikonnikova.springboot.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grade_student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GradeStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "grade")
    private int grade;

    /**
    Оценка обучающегося за занятие
    Связь многие-к-одному: ссылка на обучающегося, ссылка на занятие, балл
     */
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "student_id", referencedColumnName="id")
    private Student student;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "content_id", referencedColumnName = "content_id")
    private CourseContents courseContents;

    @Override
    public String toString() {
        return "GradeStudent{" +
                "id=" + id +
                ", grade=" + grade +
                ", student=" + student +
                ", courseContents=" + courseContents +
                '}';
    }
}
