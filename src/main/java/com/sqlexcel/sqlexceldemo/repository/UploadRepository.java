package com.sqlexcel.sqlexceldemo.repository;

import com.sqlexcel.sqlexceldemo.entity.Student;
import com.sqlexcel.sqlexceldemo.entity.UploadData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UploadRepository extends JpaRepository<UploadData,Integer> {

}