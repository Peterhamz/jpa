package com.example.datajpa.repository;

import com.example.datajpa.entity.Course;
import com.example.datajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){
        Course bchCourse = Course.builder()
                .title("BCH")
                .credit(15)
                .build();

        Course javaCourse = Course.builder()
                .title("Java")
                .credit(15)
                .build();


        Teacher teacher = Teacher.builder()
                .firstName("Rose")
                .lastName("David")
//                .courses(List.of(bchCourse, javaCourse))
                .build();

                teacherRepository.save(teacher);
    }

}