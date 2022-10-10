package com.ikonnikova.springboot.hibernate.repository;

import com.ikonnikova.springboot.hibernate.model.CourseContents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseContentRepository extends JpaRepository<CourseContents, Integer> {

    //метод, который достает все курсы с заданной датой
    @Query(value = "SELECT * FROM coursecontents c WHERE c.date_time < now()",
            nativeQuery = true)
    List<CourseContents> getRecentCourses();

}

