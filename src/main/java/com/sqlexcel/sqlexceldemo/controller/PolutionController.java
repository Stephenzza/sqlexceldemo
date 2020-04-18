package com.sqlexcel.sqlexceldemo.controller;


import com.alibaba.excel.EasyExcel;
import com.sqlexcel.sqlexceldemo.entity.Gas;
import com.sqlexcel.sqlexceldemo.entity.Student;
import com.sqlexcel.sqlexceldemo.repository.GasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

@RestController
public class PolutionController {
    @Autowired
    private GasRepository gasRepository;
    /**
     * 获取所有学生列表
     * */
    @GetMapping(value = "/gasinfo")
    public List<Gas> getAllGasInfo(){

//        Iterable iterable = studentRepository.findAll();
//        Iterator iterator = iterable.iterator();
//        List<Student> students = new ArrayList<Student>();
//        while(iterator.hasNext()){
//            students.add((Student) iterator.next());
//        }
//
//        return students;
        return gasRepository.findAll();

    }
    @GetMapping(value = "/getbysubidTest")
    public Optional<Gas> testfindByid(){
        return gasRepository.findBySubid(203);
    }
    @RequestMapping("/polutiondownload")
    public void SimpleDownload(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        String fileName = URLEncoder.encode("测试"+System.currentTimeMillis(), "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Gas.class).sheet("模板").doWrite(gasRepository.findAll());
    }

}
