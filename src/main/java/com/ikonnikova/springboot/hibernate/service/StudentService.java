package com.ikonnikova.springboot.hibernate.service;

import com.ikonnikova.springboot.hibernate.model.StudentRating;
import com.ikonnikova.springboot.hibernate.repository.CourseContentRepository;
import com.ikonnikova.springboot.hibernate.repository.StudentRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*Вычисление рейтинга
По всем занятиям курса, дата и время которых раньше текущего, берется сумма баллов за фактические оценки обучающегося
 и делятся на сумму максимальных баллов. Полученный процент (с точностью до сотых) - и есть рейтинговый балл.
 Курс считается зачтенным, если рейтинг >= 70%, а также по каждому занятию набрано не менее 70% от максимального балла.
 При этом факт зачтения дисциплины выдавать даже если все занятия еще не пройдены,
 т.е. факт того, что на данный момент обучающийся достойно выполняет нормативы курса.
 Посчитанный рейтинг хранить в таблице 6, не пересчитывать каждый раз.
*/
@Service
public class StudentService {

    @Autowired
    CourseContentRepository repository;

    @Autowired
    StudentRatingRepository studentRatingRepository;


    /*
    Метод вычисляет рейтинг студента
     */
    public Double getStudentRating(Long studentId) {
        StudentRating stId = studentRatingRepository.findByStudentId(studentId);
        if (stId == null) {
            Double rating = studentRatingRepository.getStudentRating(studentId);
            StudentRating studentRating = new StudentRating();
            studentRating.setScore(rating);
            studentRating.setStudentId(studentId);
            studentRatingRepository.save(studentRating);
            return studentRating.getScore();
        }
        return stId.getScore();

    }
}



