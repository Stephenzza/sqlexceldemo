package com.sqlexcel.sqlexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feishui")
public class Water {
    @Id
    @ExcelProperty("subid")
    private Integer subid;

    @ExcelProperty("subname")
    private String subname;

    @ExcelProperty("stcode")
    private Integer stcode;

    @ExcelProperty("tempid")
    private Integer tempid;

    @ExcelProperty("type")
    private String type;

    @ExcelProperty("areaname")
    private String areaname;

    @ExcelProperty("enterprisecode")
    private Integer enterprisecode;

    @ExcelProperty("longitude")
    private Double longitude;

    @ExcelProperty("latitude")
    private Double latitude;

    @ExcelProperty("pname")
    private String pname;

    @ExcelProperty("minunitname")
    private String minunitname;

    @ExcelProperty("minunitcode")
    private String minunitcode;


}
