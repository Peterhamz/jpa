package com.example.datajpa.repository;

import com.example.datajpa.entity.Course;
import com.example.datajpa.entity.Student;
import com.example.datajpa.entity.Teacher;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();

        System.out.println("courses: " + courses);

    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("rose")
                .lastName("David")
                .build();


        Course course = Course.builder()
                .title(".net")
                .credit(4)
                .teacher(teacher)
                .build();


        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable findPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);


        List<Course> courses =
                courseRepository.findAll(findPageWithThreeRecords)
                        .getContent();

        List<Course> courses2 =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements = courseRepository.findAll(findPageWithThreeRecords)
                .getTotalElements();

        long totalPages = courseRepository.findAll(findPageWithThreeRecords)
                .getTotalPages();

        System.out.println("totalElements: " + totalElements);


        System.out.println("totalPages: " + totalPages);


        System.out.println("courses: " + courses);


        System.out.println("courses2: " + courses2);



    }

    @Test
    public void findAllSorting(){
    Pageable sortByTitle =
            PageRequest.of(0, 2, Sort.by("title").ascending());

    Pageable sortByCreditDesc =
            PageRequest.of(0, 2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(
                        0,
                        2,
                        Sort.by("title").descending()
                                .and(Sort.by("credit"))
                );


        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses: " + courses);
    }

    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository
                        .findByTitleContaining("D",firstPageTenRecords).getContent();

        System.out.println("courses: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("peru")
                .lastName("para")
                .build();


        Student student = Student.builder()
                .firstName("peter")
                .lastName("phjames")
                .emailId("peterhamzat5@gmail.com")
                .build();


        Course course = Course.builder()
                .title("AI")
                .credit(23)
                .teacher(teacher)
                .build();


        course.addStudent(student);


        courseRepository.save(course);
    }

}