package com.ikonnikova.springboot.hibernate.repository;

import com.ikonnikova.springboot.hibernate.model.GradeStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeStudentRepository extends JpaRepository<GradeStudent, Integer> {


}
