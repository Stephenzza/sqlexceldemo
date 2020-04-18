package com.sqlexcel.sqlexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feiqi_paiwu")
public class GasContam {
    @Id
    @ExcelProperty("subid")
    private Integer subid;

    @ExcelProperty("pname")
    private String pname;

    @ExcelProperty("datatime")
    private String datatime;

    @ExcelProperty("itemcode")
    private Integer itemcode;

    @ExcelProperty("itemvalue")
    private Double itemvalue;

    @ExcelProperty("standard")
    private Double standard;

    @ExcelProperty("status")
    private Boolean status;

}
