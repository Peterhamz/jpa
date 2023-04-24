package com.example.datajpa.repository;

import com.example.datajpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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






        //       native
        @Query(
                value = "select * from tbl_student s where s.email_address = ?1",
                nativeQuery = true
        )
        Student getStudentByEmailAddressNative(String emailId);







        //       native named param
        @Query(
                value = "select * from tbl_student s where s.email_address = :emailId",
                nativeQuery = true
        )
        Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);




//        native
        @Modifying
        @Transactional
        @Query(value = "update stbl_student set first_name = ?1 where email_address = ?2",
                nativeQuery = true
        )
        int updateStudentNameByEmailId(String firstName, String emailId);

}
