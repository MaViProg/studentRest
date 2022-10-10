package com.ikonnikova.springboot.hibernate.repository;

import com.ikonnikova.springboot.hibernate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}
