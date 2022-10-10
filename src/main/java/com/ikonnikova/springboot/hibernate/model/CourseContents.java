package com.ikonnikova.springboot.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
Занятие (ссылка на курс, название, дата-время, максимальная оценка)
 */
@Entity
@Table(name = "coursecontents")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseContents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Integer id;

    private String content;

    @ManyToMany(mappedBy = "coursecontents")
    private Set<Course> courses = new HashSet<>();

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "max_grade")
    private int maxGrade;

    @Override
    public String toString() {
        return "CourseContents{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", courses=" + courses +
                ", dateTime=" + dateTime +
                ", maxGrade=" + maxGrade +
                '}';
    }
}
