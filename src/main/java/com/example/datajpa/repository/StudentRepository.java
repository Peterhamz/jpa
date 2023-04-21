package com.example.datajpa.repository;

import com.example.datajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
        List<Student> findByFirstName(String firstName);

        List<Student> findByFirstNameContaining(String name);

        @Query("select s from Student s where s.emailId = ?1")
        Student findStudentByEmailId(String emailId);

        @Query("select s.firstName from Student s where s.emailId = ?1")
        String getStudentFirstName(String emailId);

}
