package com.sqlexcel.sqlexceldemo.controller;

import com.alibaba.excel.EasyExcel;
import com.sqlexcel.sqlexceldemo.Listener.UploadDataListener;
import com.sqlexcel.sqlexceldemo.entity.UploadData;
import com.sqlexcel.sqlexceldemo.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Controller
public class UploadExcelController {

    @Autowired
    private UploadRepository uploadRepository;

    @RequestMapping(value = "/uploadExcel")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        System.out.println(filename);
        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadRepository)).sheet().doRead();
        return "success";
    }

}

