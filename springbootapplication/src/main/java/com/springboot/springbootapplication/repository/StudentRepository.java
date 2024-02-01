package com.springboot.springbootapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.springbootapplication.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
Student findByEmail(String email);
List<Student> getByAgeGreaterThan(int age);
@Query("select s from Student s where s.email=?1")
Student getByEmailQuery(String email);
}
