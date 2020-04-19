package com.sqlexcel.sqlexceldemo.entity;

import com.alibaba.excel.annotation.ExcelProperty;

import javax.persistence.*;

@Entity
@Table( name="feiqi")
public class Gas {
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
    private Long enterprisecode;

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

    public Integer getSubid() {
        return subid;
    }

    public String getSubname() {
        return subname;
    }

    public Integer getStcode() {
        return stcode;
    }

    public Integer getTempid() {
        return tempid;
    }

    public String getType() {
        return type;
    }

    public String getAreaname() {
        return areaname;
    }

    public Long getEnterprisecode() {
        return enterprisecode;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public String getPname() {
        return pname;
    }

    public String getMinunitname() {
        return minunitname;
    }

    public String getMinunitcode() {
        return minunitcode;
    }
}
