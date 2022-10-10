package com.ikonnikova.springboot.hibernate;

import com.ikonnikova.springboot.hibernate.model.Course;
import com.ikonnikova.springboot.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestStudentApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestStudentApplication.class, args);

    }
}
