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

    @ExcelProperty("datetime")
    private String datetime;

    @ExcelProperty("itemcode")
    private Integer itemcode;

    @ExcelProperty("itemvalue")
    private Double itemvalue;

    @ExcelProperty("standard")
    private Double standard;

    @ExcelProperty("status")
    private String status;

    public Integer getSubid() {
        return subid;
    }

    public String getPname() {
        return pname;
    }

    public String getDatatime() {
        return datetime;
    }

    public Integer getItemcode() {
        return itemcode;
    }

    public Double getItemvalue() {
        return itemvalue;
    }

    public Double getStandard() {
        return standard;
    }

    public String getStatus() {
        return status;
    }
}
