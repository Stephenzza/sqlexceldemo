package com.sqlexcel.sqlexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @ExcelProperty("id")
    private Integer id;

    @ExcelProperty("name")
    private String name;

    @ExcelProperty("sex")
    private Integer sex;

    @ExcelProperty("age")
    private Integer age;

}
