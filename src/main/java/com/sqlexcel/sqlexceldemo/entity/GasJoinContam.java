package com.sqlexcel.sqlexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;


public class GasJoinContam implements Serializable {
    @ExcelProperty("subid")
    @Transient
    private Integer subid;

    @Transient
    @ExcelProperty("pname")
    private String pname;

    @Transient
    @ExcelProperty("datetime")
    private String datetime;


    public GasJoinContam(){}
    public GasJoinContam(Integer subid, String pname, String datetime) {
        super();
        this.subid = subid;
        this.pname = pname;
        this.datetime = datetime;
    }

    public Integer getSubid() {
        return subid;
    }

    public String getPname() {
        return pname;
    }

    public String getDatetime() {
        return datetime;
    }
}
