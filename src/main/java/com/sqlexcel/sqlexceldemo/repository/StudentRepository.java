package com.sqlexcel.sqlexceldemo.repository;

import com.sqlexcel.sqlexceldemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByName(String name);

    @Query(value="from Student stu where stu.id=?1")
    Optional<Student> findById(Integer id);
}