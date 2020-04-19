package com.sqlexcel.sqlexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name="unit_name")
public class UnitName {
    @Id
    @ExcelProperty("itemcode")
    private Integer itemcode;

    @ExcelProperty("itemname")
    private String itemname;

    @ExcelProperty("unit")
    private String unit;

    public Integer getItemcode() {
        return itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public String getUnit() {
        return unit;
    }
}
