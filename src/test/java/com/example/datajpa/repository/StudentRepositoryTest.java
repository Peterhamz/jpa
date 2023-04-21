package com.example.datajpa.repository;

import com.example.datajpa.entity.Guardian;
import com.example.datajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("peterhamza@gmail.com")
                .firstName("peter")
//                .guardianEmail("hamzajames@gmail.com")
//                .guardianMobile("09033210761")
                .lastName("james")
//                .guardianName("jameshamza")
                .build();


        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();

        System.out.println("StudentList : " + studentList);
    }

    @Test
    public void saveStudents(){

        Guardian guardian = Guardian.builder()
                .email("phjamesdfdv@gmail.com")
                .name("phjames")
                .mobileNumber("09044320883")
                .build();

        Student student = Student.builder()
                .guardian(guardian)
                .emailId("james@peter.com")
                .firstName("peter")
                .lastName("Hamza")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void findByFirstNameContaining(){
        List<Student> nameContaining = studentRepository.findByFirstNameContaining("hj");

        System.out.println("nameContaining: " + nameContaining);
    }
    @Test
    public void findByFirstName(){
        List<Student> firstName = studentRepository.findByFirstName("peter");

        System.out.println("Student: " + firstName);
    }

    @Test
    public void findByEmailAddress(){
        Student student = studentRepository.findStudentByEmailId("james@peter.com");

        System.out.println("Student: " + student);
    }


    @Test
    public void findByFirsName(){
        String student = studentRepository.getStudentFirstName("james@peter.com");

        System.out.println("Student: " + student);
    }
}

