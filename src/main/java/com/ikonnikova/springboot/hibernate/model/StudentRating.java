package com.ikonnikova.springboot.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student_rating")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "score")
    private double score;

    @Column(name = "student_id")
    private Long studentId;

    @Override
    public String toString() {
        return "StudentRating{" +
                "id=" + id +
                ", score=" + score +
                ", student=" + studentId +
                '}';
    }
}
