package com.ikonnikova.springboot.hibernate.repository;

import com.ikonnikova.springboot.hibernate.model.StudentRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRatingRepository extends JpaRepository<StudentRating, Integer> {

    //Метод вычисляет рейтинг складывая фактические оценки и деля их на максимальный балл
    @Query(value = "SELECT (cast(SUM(g.grade) AS DECIMAL)  / c.max_grade) AS rating\n" +
            "FROM   students s\n" +
            "       join grade_student g\n" +
            "         ON s.id = g.student_id\n" +
            "       join coursecontents c\n" +
            "         ON g.content_id = c.content_id\n" +
            "WHERE  s.id = ?1\n" +
            "GROUP  BY s.id,\n" +
            "          c.max_grade", nativeQuery = true)
    Double getStudentRating(Long studentId);

    StudentRating findByStudentId(Long studentId);
}
