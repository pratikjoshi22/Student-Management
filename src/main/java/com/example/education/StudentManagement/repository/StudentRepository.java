package com.example.education.StudentManagement.repository;

import com.example.education.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String name);
    public List<Student> findByCollegeName(String name);




}

